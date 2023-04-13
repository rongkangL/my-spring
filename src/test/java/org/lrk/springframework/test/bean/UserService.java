package org.lrk.springframework.test.bean;

/**
 * @Author: lrk
 * @Date: 2023/4/12 下午 9:54
 * @Description:
 */
public class UserService {

    private String name;

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }
}
