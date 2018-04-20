package lovely.baby.online.mall.backstage.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lovely.baby.online.mall.backstage.dao.mybatis.AdminDao;
import lovely.baby.online.mall.backstage.model.Admin;
import lovely.baby.online.mall.backstage.service.AdminService;

@RequiredArgsConstructor
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao;

    @Override
    public Admin adminVerify(String name, String password) {
        return adminDao.queryByNameAndPwd(name, password);
    }
}
