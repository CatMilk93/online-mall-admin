package lovely.baby.online.mall.backstage.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestDataHolder {

    private final ThreadLocal<String> ip = ThreadLocalCleaner.register(new ThreadLocal<>());

    private final ThreadLocal<String> name = ThreadLocalCleaner.register(new ThreadLocal<>());

    /**
     * 获取ip
     *
     * @return 请求的IP
     */
    public String getIP() {
        return ip.get();
    }

    /**
     * 设置用户ip
     *
     * @param _ip 请求的IP
     */
    public void setIP(String _ip) {
        ip.set(_ip);
    }

    /**
     * 获取用户名
     *
     * @return 请求的IP
     */
    public String getName() {
        return name.get();
    }

    /**
     * 设置用户名
     *
     * @param _username 请求的IP
     */
    public void setName(String _username) {
        name.set(_username);
    }
}
