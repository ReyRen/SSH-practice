package company.whoami.service.impl;

import company.whoami.dao.IAdminDao;
import company.whoami.entity.Admin;
import company.whoami.service.IAdminService;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:26
 */
public class AdminService implements IAdminService {
    //注入dao
    private IAdminDao adminDao;//不能用实现，代理对象，利用接口用的就是jdk代理，放在容器中肯定是实现，不是接口
    public void setAdminDao(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public void register(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.findByAdmin(admin);
    }
}
