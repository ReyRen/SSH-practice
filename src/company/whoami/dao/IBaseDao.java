package company.whoami.dao;

import java.util.List;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/4 下午5:41
 */
/*所用DAO的通用操作接口定义，泛型接口*/
public interface IBaseDao<T> {
    /**
     * 保存
     * @param t
     */
    void save(T t);

    /**
     * 跟新对象信息
     * @param t
     */
    void update(T t);

    /**
     * 根据主键删除
     * @param id
     */
    void delete(int id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T findById(int id);

    /**
     * 查询全部
     * @return
     */
    List<T> getAll();

}
