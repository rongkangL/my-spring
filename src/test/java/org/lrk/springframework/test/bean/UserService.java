package org.lrk.springframework.test.bean;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 9:54
 * @Description:
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }


    public UserService() {
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
