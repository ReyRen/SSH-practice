package company.whoami.dao;

import company.whoami.entity.Employee;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午8:57
 */
//员工接口
public interface IEmployeeDao {
    //保存员工
    void save(Employee employee);
    //更新员工信息
    void update(Employee employee);
    //根据主键删除
    void delete(int id);
    //根据主键查询
    Employee findById(int id);
    //查询全部
    List<Employee> getAll();
    //通过员工名称条件查询
    List<Employee> getAll(String name);
}
