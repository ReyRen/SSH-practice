package company.whoami.service.impl;

import company.whoami.dao.IEmployeeDao;
import company.whoami.entity.Employee;
import company.whoami.service.IEmployeeService;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:27
 */
public class EmployeeService implements IEmployeeService {
    private IEmployeeDao employeeDao;

    public void setEmployeeDao(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<Employee> getAll(String name) {
        return employeeDao.getAll(name);
    }

    @Override
    public void deletMany(int[] ids) {
        if (ids != null && ids.length > 0){
            for (int i:ids){
                delete(ids[i]);
            }
        }
    }
}
