package lovely.baby.online.mall.backstage.util;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public class AESEncryptUtils {

    private final SecretKey KEY = new SecretKeySpec(new byte[] { 90, -33, -85, -78, 39, -42, -74, -9, 113, 36, 107, -22,
            19, -42, -72, 89, -25, 40, -63, -121, 124, 38, -85, 116, 5, -107, -73, 96, -109, 18, -109, -110 }, "AES");

    private final IvParameterSpec IV = new IvParameterSpec(
            new byte[] { 111, 69, -104, 85, -15, -80, -99, 62, 16, 122, 82, 57, 77, 95, -66, 114 });

    private final byte VERSION = 1;

    public String encrypt(@NonNull String string, @NonNull Charset charset) {
        byte[] allBytes = null;
        try {
            byte[] raw = string.getBytes(charset);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, KEY, IV);
            byte[] encrypted = cipher.doFinal(raw);

            // add version for further extend
            // VERSION 1: byte[0] -> 0001**** (* is random data), byte[1-n] -> encryped data
            allBytes = new byte[encrypted.length + 1];
            allBytes[0] = (byte) ((VERSION << 4) + ((int) (Math.random() * 16) & 0xf));
            System.arraycopy(encrypted, 0, allBytes, 1, encrypted.length);

            // convert to base64 string
            return Base64.getEncoder().encodeToString(allBytes);
        } catch (Exception e) {
            log.error("加密失败: string = {}, allBytes[0] = {}", string, allBytes, e);
            throw new RuntimeException(e);
        }
    }

    public String decrypt(@NonNull String string) {
        try {
            // decode from base64
            byte[] allBytes = Base64.getDecoder().decode(string);

            // check version
            byte version = (byte) ((allBytes[0] & 0xf0) >>> 4);
            if (version != VERSION) {
                throw new IllegalArgumentException("version " + version + " not supported");
            }
            byte[] raw = new byte[allBytes.length - 1];
            System.arraycopy(allBytes, 1, raw, 0, raw.length);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, KEY, IV);
            byte[] decrypted = cipher.doFinal(raw);

            return new String(decrypted, "UTF-8");
        } catch (Exception e) {
            log.error("解密失败: string = {}", string, e);
            throw new RuntimeException(e);
        }
    }
}
