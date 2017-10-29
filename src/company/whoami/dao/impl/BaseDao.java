package company.whoami.dao.impl;

import company.whoami.dao.IBaseDao;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/4 下午5:40
 */
/*通用dao的实现，所有的dao都继承此类*/
public class BaseDao<T> implements IBaseDao<T> {
    //得到当前操作的实际的bean类型,
    private Class<T> clazz;
    //获取类名称
    private String className;

    //反射泛型,也即是获取当前调用的类

    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        //转换为参数化类型
        ParameterizedType pt = (ParameterizedType)type;//BaseDao<Employee>
        //得到实际类型
        Type types[] = pt.getActualTypeArguments();
        //获取实际类型
        clazz = (Class<T>)types[0];
        className = clazz.getSimpleName();//Employee
    }

    //IOC容器注入依赖sessionFactory对象
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().createQuery("delete from " + className +" where id=?").setParameter(0,id).executeUpdate();
    }

    @Override
    public T findById(int id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public List getAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + className).list();
    }
}
