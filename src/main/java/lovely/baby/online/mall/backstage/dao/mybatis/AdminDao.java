package lovely.baby.online.mall.backstage.dao.mybatis;

import org.apache.ibatis.annotations.Param;

import lovely.baby.online.mall.backstage.model.Admin;

public interface AdminDao {

    Admin queryByNameAndPwd(@Param("name") String name, @Param("password") String password);
}
