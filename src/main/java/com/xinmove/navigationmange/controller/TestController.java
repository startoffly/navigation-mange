package com.xinmove.navigationmange.controller;

import com.alibaba.fastjson.JSONObject;
import com.xinmove.navigationmange.controller.vo.CardGroupOutVo;
import com.xinmove.navigationmange.controller.vo.ReturnBody;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;
import com.xinmove.navigationmange.service.CardService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: startoffly
 * @Date: 2020/10/5 16:47
 * @Description:
 */

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    private CardService cardService;
    @Resource
    private CardGroupService cardGroupService;

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getHeadInfo")
    public ReturnBody getHeadInfo(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","星幕之家");
        jsonObject.put("keywords","Get异步关键词 1 2 3");
        jsonObject.put("description","Get异步简介");
        jsonObject.put("author","startoffly");
        return ReturnBody.success(jsonObject);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getInfo")
    public ReturnBody getInfo(){
        return ReturnBody.success(getTestCards());
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getCardsByGroup")
    public ReturnBody getHomeInfo(@RequestParam(value = "gids") Integer[] gids){
        List<CardGroupOutVo> cardGroupOutVos = new ArrayList<>();
        for (int gid : gids) {
            Optional<CardGroup> cardGroupOptional1 = cardGroupService.findOne(gid);
            cardGroupOutVos.add(cardGroupOptional1.map(CardGroupOutVo::new).orElseGet(() -> new CardGroupOutVo(1)));
        }
        return ReturnBody.success(cardGroupOutVos);
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/getCardsByGroupAll")
    public ReturnBody getHomeInfoAll(){
        List<CardGroupOutVo> cardGroupOutVos = new ArrayList<>();
        for (CardGroup cardGroup : cardGroupService.findAllOrderByRankDesc()) {
            cardGroupOutVos.add(new CardGroupOutVo(cardGroup));
        }
        return ReturnBody.success(cardGroupOutVos);
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
