package company.whoami.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import company.whoami.entity.Dept;
import company.whoami.entity.Employee;
import company.whoami.service.IDeptService;
import company.whoami.service.IEmployeeService;
import org.apache.struts2.interceptor.RequestAware;

import java.util.List;
import java.util.Map;

/**
 * @Author Yuan Ren.
 * @Description
 *
 * 1.员工列表展示
 *  2.显示
 *  3.修改员工信息
 * @Date 2017/8/3 下午10:53
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware{
    /***************1.封装数据,添加用******************/
    private Employee employee = new Employee();//使用模型驱动
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Employee getEmployee() {
        return employee;
    }
    @Override
    public Employee getModel() {
        return employee;//返回实例化后的对象
    }
    //封装请求的部门id(下拉列表的实际的值)
    private int deptId;
    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    /***************2.注入service******************/
    private IEmployeeService employeeService;
    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    private IDeptService deptService;
    public void setDeptService(IDeptService deptService) {
        this.deptService = deptService;
    }



    public String list(){
        List<Employee> listEmp =  employeeService.getAll();
        request.put("listEmp",listEmp);
        return "list";
    }

    //进入添加页面
    public String viewAdd(){
        //查询所有部门，保存都request，下拉列表
        List<Dept> listDept = deptService.getAll();
        request.put("listDept",listDept);
        return "add";
    }

    //添加员工数据
    public String save(){
        //根据部门主键进行查询
        Dept dept = deptService.findById(deptId);
        //设置到员工对象中
        employee.setDept(dept);
        //保存员工
        employeeService.save(employee);//通过映射会自动维护员工与部门的关系
        return "listAction";//要用重定向，防止重复提交表单
    }


    /*进入修改视图*/
    public String viewUpdate(){
        //获取 要修改的记录的id
        int id = employee.getId();//这个id是前台页面传过来，然后模型驱动封装了的
        //根据员工的主键查询(lazy = false),这样的话，懒加载关闭，这样在根据主键查询员工的时候就有了部门信息了存进了emp中，要是有懒加载得调用部门信息的时候才能有懒加载，但是懒加载出了session就不能用了，这样，前台是获取不到的。
        Employee emp = employeeService.findById(id);
        //查询所有的部门
        List<Dept> listDept = deptService.getAll();
        //数据回显
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.pop();//移除栈顶元素
        vs.push(emp);//入栈

        //保存
        request.put("listDept",listDept);//这个是单独的
        return "edit";

    }

    /*确认修改*/
    public String update(){
        //1.先根据部门id查询部门对象，再设置到员工属性中
        Dept dept = deptService.findById(deptId);
        employee.setDept(dept);
        //2.更新员工
        employeeService.update(employee);
        return "listAction";//重定向到列表
    }

    /*删除*/
    public String delete(){
        //获取要删除员工的主键
        int empId = employee.getId();
        //调用service删除
        employeeService.delete(empId);

        return "listAction";
    }




    //接收框架运行时期，传入的代表request对象的map
    private Map<String,Object> request;//因为实现了RequestAware接口
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

}
