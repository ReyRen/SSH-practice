package company.whoami.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import company.whoami.entity.Admin;
import company.whoami.service.IAdminService;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/4 下午6:48
 */

//管理员登录注册模块儿
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

    //封装请求数据
    private Admin admin = new Admin();
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    private IAdminService adminService;
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Admin getModel() {
        return admin;//返回是实例化的admin
    }

    /*登录*/
    public String login(){
        //登录验证
        Admin adminInfo = adminService.login(admin);
        if (adminInfo == null){
            //登录失败
            return "loginFaild";
        }else {
            //登录成功
            //保存数据到session
            ActionContext.getContext().getSession().put("adminInfo",adminInfo);
            return "index";
        }
    }
}
