package company.whoami.entity;

/**
 * @Author Yuan Ren.
 * @Description
 * @Date 2017/8/3 下午8:49
 */
public class Admin {

    private int id;
    private String adminName;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
