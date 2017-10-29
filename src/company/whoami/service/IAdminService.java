package company.whoami.service;

import company.whoami.entity.Admin;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:22
 */
public interface IAdminService {
    //注册
    void register(Admin admin);

    //登录
    Admin login(Admin admin);
}
