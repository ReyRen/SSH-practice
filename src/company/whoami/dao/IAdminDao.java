package company.whoami.dao;

import company.whoami.entity.Admin;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午8:53
 */
//管理员dao
public interface IAdminDao {
    //保存
    void save(Admin admin);

    //根据管理员信息查询，返回查询后的结果
    Admin findByAdmin(Admin admin);
}
