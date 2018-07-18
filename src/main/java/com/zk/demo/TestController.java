package com.zk.demo;

import com.alibaba.fastjson.JSONObject;
import com.zk.demo.zk_lock.InputParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author: garychen
 * @Date: 2018/7/18 16:45
 * @Description:
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @ResponseBody
    @PostMapping(value = "/test")
    public Object test001(@RequestBody InputParam inputParam) {
        System.out.println(inputParam.toString());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ok","0000");
        return jsonObject;
    }
}
