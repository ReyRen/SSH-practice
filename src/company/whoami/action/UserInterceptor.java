package company.whoami.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/4 下午7:18
 */
//校验管理员是否登录，只有登陆后才能操作
public class UserInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        //得到当前执行的方法
        String methodName = actionInvocation.getProxy().getMethod();

        //得到ActionContext对象
        ActionContext ac = actionInvocation.getInvocationContext();
        //获取session,然后从session中获取登录的管理员账号
        Object obj = ac.getSession().get("adminInfo");

        //判断
        if ((!"login".equals(methodName)) && (!"list".equals(methodName))){//这个的意思就是说，你没登录直接访问list是可以的，但是如果是其他的增删改查方法的话，都要进行登录验证了
            //验证
            if (obj == null){
                //没有登录
                return "login";
            }else{
                return actionInvocation.invoke();
            }

        }else {
            //允许访问
            return actionInvocation.invoke();
        }


    }
}
