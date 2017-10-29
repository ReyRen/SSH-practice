package company.whoami.dao.impl;

import company.whoami.dao.IAdminDao;
import company.whoami.entity.Admin;
import org.hibernate.SessionFactory;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午8:59
 */
public class AdminDao implements IAdminDao {

    //IOC容器注入依赖sessionFactory对象
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Admin admin) {
        sessionFactory.getCurrentSession().save(admin);
    }

    @Override
    public Admin findByAdmin(Admin admin) {
        return (Admin) sessionFactory.getCurrentSession().
                createQuery("from Admin where adminName=? and pwd=?").
                setString(0,admin.getAdminName()).
                setString(1,admin.getPwd()).uniqueResult();
    }
}
