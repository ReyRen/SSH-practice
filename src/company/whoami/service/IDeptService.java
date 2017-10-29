package company.whoami.service;

import company.whoami.entity.Dept;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午9:22
 */
public interface IDeptService {
    //查询全部
    List<Dept> getAll();

    //根据主键查询
    Dept findById(int id);
}
