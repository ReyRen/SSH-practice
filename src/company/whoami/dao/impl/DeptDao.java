package company.whoami.dao.impl;

import company.whoami.dao.IDeptDao;
import company.whoami.entity.Dept;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:00
 */
public class DeptDao implements IDeptDao {

    //IOC容器注入依赖sessionFactory对象
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Dept> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Dept").list();
    }

    @Override
    public Dept findById(int id) {
        return (Dept)sessionFactory.getCurrentSession().get(Dept.class,id);
    }
}
