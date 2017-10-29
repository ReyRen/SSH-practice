package company.whoami.dao;

import company.whoami.entity.Dept;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午8:55
 */
//部门接口
public interface IDeptDao {
    //查询全部
    List<Dept> getAll();

    //根据主键查询
    Dept findById(int id);
}
