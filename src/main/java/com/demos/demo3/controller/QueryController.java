package com.demos.demo3.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demos.demo3.beans.Person;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.demos.demo3.service.PersonClassify;

import java.util.Iterator;
import java.util.Map;

@RestController
public class QueryController {
    PersonClassify personClassify = new PersonClassify();
    @RequestMapping(value = "/json/data", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJSON(@RequestParam Map<String,JSONObject> jsonParam) {

        //打印收到的json
        System.out.println(jsonParam);
        //规则匹配
        JSONObject result = personClassify.queryEmail(jsonParam);
        return result.toJSONString();
    }

}
