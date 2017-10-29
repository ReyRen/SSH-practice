package company.whoami.dao.impl;

import company.whoami.dao.IEmployeeDao;
import company.whoami.entity.Employee;


import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:01
 */
public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {


//父类的属性就是子类的属性，所以spring那里不用改，直接写注入就行
    @SuppressWarnings("unckecked")
    @Override
    public List<Employee> getAll(String name) {
        return getSessionFactory().getCurrentSession().createQuery("from Employee where empName like ?").setParameter(0,"%" + name + "%").list();
    }
}
