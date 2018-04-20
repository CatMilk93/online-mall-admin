package lovely.baby.online.mall.backstage.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus implements HasCode<Integer> {
    SUBMITTED(0, "未付款"), //
    PAID(1, "已支付"), //
    DELIVERED(2, "已发货"), //
    RECEIVED(3, "已收货");

    private final Integer code;

    private final String desc;
}
