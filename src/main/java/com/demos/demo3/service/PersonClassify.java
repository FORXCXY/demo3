package com.demos.demo3.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import com.demos.demo3.beans.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class PersonClassify {
    public JSONObject queryEmail(Map<String, JSONObject> jsonParam) {
        //公司邮箱映射表
        HashMap<String, String> orgEmailMap = new HashMap<String, String>() {
            {
                put("gmail.com", "谷歌公司");
                put("qq.com", "腾讯公司");
                put("163.com", "网易公司");
                put("microsoft.com", "微软公司");
            }
        };
        //姓名公司映射表
        HashMap<String, String> orgNameMap = new HashMap<String, String>() {
            {
                put("任正非", "华为公司");
                put("马化腾", "腾讯公司");
                put("雷军", "小米公司");
                put("比尔盖茨", "微软公司");
            }
        };
        //电话公司映射表
        HashMap<String, String> orgPhoneMap = new HashMap<String, String>() {
            {
                put("11111111", "华为公司");
                put("22222222", "腾讯公司");
                put("33333333", "小米公司");
                put("44444444", "微软公司");
            }
        };
//        //投票分数表
//        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>(){
//            {
//                put("华为公司",0);
//                put("腾讯公司",0);
//                put("小米公司",0);
//                put("微软公司",0);
//            }
//        };

        //返回表
        JSONObject result = new JSONObject();
        result.put("msg", "ok");
        result.put("method", "json");
        result.put("org", "");
        Person person = new Person();

        ///获取json数据
        String data = null;
        for (Map.Entry<String, JSONObject> vo : jsonParam.entrySet()) {
            vo.getKey();
            vo.getValue();
            data = vo.getKey();
        }
        JSONObject jsonObject = JSON.parseObject(data);
        //把options的json数据提取出来
        JSONObject optionsMap = (JSONObject) jsonObject.get("options");

        //把所有data提取出来

        String name = (String) jsonObject.get("name");
        String email = (String) jsonObject.get("email");
        String phone = (String) jsonObject.get("phoneNum");
        String country = (String) jsonObject.get("country");
        String passport = (String) jsonObject.get("passport");
        String work = (String) jsonObject.get("work");
        Boolean call_f = optionsMap.get("call_f") != null;
        Boolean social_f = optionsMap.get("social_f") != null;
        String[] org;

        //截取邮箱域名
        org = email.split("@");
        //逻辑匹配

        if (orgNameMap.get(name) != null) {
            result.put("org", orgNameMap.get(name));
            System.out.println(result);
            return result;
        } else if (orgEmailMap.get(org[1]) != null) {
            result.put("org", orgEmailMap.get(org[1]));
            System.out.println(result);
            return result;
        } else if (orgPhoneMap.get(phone) != null) {
            result.put("org", orgPhoneMap.get(phone));
            System.out.println(result);
            return result;
        } else if (country != null || passport != null || work != null || social_f || call_f) {
            int resultScore = 0;
            if(!Objects.equals(country, "")){
                resultScore += 1;
            }
            if(!Objects.equals(passport, "")){
                resultScore += 10;
            }
            if(!Objects.equals(work, "")){
                resultScore += 100;
            }
            if(social_f){
                resultScore += 1000;
            }
            if(call_f){
                resultScore += 10000;
            }
            HashMap<Integer,String> orgScore = new HashMap<Integer,String>(){
                {
                    put(1,"微软公司");
                    put(11,"华为公司");
                    put(101,"小米公司");
                    put(1001,"微软公司");
                    put(10001,"网易公司");
                    put(111,"谷歌公司");
                    put(1101,"微软公司");
                    put(1111,"微软公司");
                    put(100,"小米公司");
                    put(1000,"华为公司");
                    put(10000,"华为公司");
                    put(10111,"微软公司");
                    put(10011,"微软公司");
                    put(10010,"网易公司");
                    put(11011,"网易公司");
                    put(1011,"微软公司");
                    put(1100,"谷歌公司");
                    put(1010,"腾讯公司");
                    put(110,"微软公司");
                    put(10101,"微软公司");
                    put(10100,"谷歌公司");
                    put(10110,"微软公司");
                    put(11000,"华为公司");
                    put(11100,"华为公司");
                    put(1110,"网易公司");
                    put(11110,"谷歌公司");

                }
            };
            if(orgScore.get(resultScore) != null){
                System.out.println(orgScore.get(resultScore));
                System.out.println(resultScore);
                result.put("org", orgScore.get(resultScore));
                result.put("msg", "200");
                return result;
            }
        }else{
        }
        result.put("org","NULL");
        result.put("msg","404");
        return result;
    }

}


