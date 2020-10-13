package com.xinmove.navigationmange.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinmove.navigationmange.controller.vo.ReturnBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: startoffly
 * @Date: 2020/10/5 16:47
 * @Description:
 */

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/postHeadInfo")
    public ReturnBody postHeadInfo(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","星幕之家");
        jsonObject.put("keywords","POST异步关键词 1 2 3");
        jsonObject.put("description","POST异步简介");
        jsonObject.put("author","startoffly");
        return ReturnBody.success(jsonObject);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getHeadInfo")
    public ReturnBody getHeadInfo(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","Get异步标题");
        jsonObject.put("keywords","Get异步关键词 1 2 3");
        jsonObject.put("description","Get异步简介");
        jsonObject.put("author","startoffly");
        return ReturnBody.success(jsonObject);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getInfo")
    public ReturnBody getInfo(){

        List<JSONObject> datas = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","哈里哈利");
        jsonObject.put("id","哈里哈利");
        jsonObject.put("url","halihali.li/");
        jsonObject.put("description","在线观看各类视频");
        jsonObject.put("img","http://www.xinmove.com/image/uploadpic/xinmove_com_halihali46asdwda456a74w6.png");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","扫把博客");
        jsonObject.put("id","扫把博客");
        jsonObject.put("url","blog.xinmove.com");
        jsonObject.put("description","扫把的博客");
        jsonObject.put("img","http://www.xinmove.com/image/title-logo.png");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","百度");
        jsonObject.put("id","百度");
        jsonObject.put("url","www.baidu.com");
        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
        jsonObject.put("img","https://www.baidu.com/favicon.ico");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","百度2");
        jsonObject.put("id","百度2");
        jsonObject.put("url","www.baidu.com");
        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
        jsonObject.put("img","https://www.baidu.com/favicon.ico");
        datas.add(jsonObject);
        return ReturnBody.success(datas);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getHomeInfo")
    public ReturnBody getHomeInfo(){




        return ReturnBody.success(getTestCards());
    }

    /**
     * 测试数据
     * @return
     */
    private List<JSONObject> getTestCards(){
        List<JSONObject> datas = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","哈里哈利");
        jsonObject.put("id","哈里哈利");
        jsonObject.put("url","halihali.li/");
        jsonObject.put("description","在线观看各类视频");
        jsonObject.put("img","http://www.xinmove.com/image/uploadpic/xinmove_com_halihali46asdwda456a74w6.png");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","扫把博客");
        jsonObject.put("id","扫把博客");
        jsonObject.put("url","blog.xinmove.com");
        jsonObject.put("description","扫把的博客");
        jsonObject.put("img","http://www.xinmove.com/image/title-logo.png");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","百度");
        jsonObject.put("id","百度");
        jsonObject.put("url","www.baidu.com");
        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
        jsonObject.put("img","https://www.baidu.com/favicon.ico");
        datas.add(jsonObject);
        jsonObject = new JSONObject();
        jsonObject.put("name","百度2");
        jsonObject.put("id","百度2");
        jsonObject.put("url","www.baidu.com");
        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
        jsonObject.put("img","https://www.baidu.com/favicon.ico");
        datas.add(jsonObject);
        return datas;
    }

}
