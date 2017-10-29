package company.whoami.service.impl;

import company.whoami.dao.IDeptDao;
import company.whoami.entity.Dept;
import company.whoami.service.IDeptService;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:27
 */
public class DeptService implements IDeptService {
    private IDeptDao deptDao;

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }

    @Override
    public Dept findById(int id) {
        return deptDao.findById(id);
    }
}
