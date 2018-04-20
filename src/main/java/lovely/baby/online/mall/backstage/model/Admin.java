package lovely.baby.online.mall.backstage.model;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Admin {

    private int id;

    private String name;

    private String password;

    private String email;

    private String telephone;

    private Date createTime;

    private Date updateTime;
}