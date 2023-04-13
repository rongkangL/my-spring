package org.lrk.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lrk
 * @Date: 2023/4/13 下午 2:40
 * @Description:
 */
public class UserDao {
    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("10001", "油饼");
        map.put("10002", "香精监狱");
        map.put("10003", "荔枝");
    }

    public String queryUserName(String uId){
        return map.get(uId);
    }
}
