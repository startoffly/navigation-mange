package com.xinmove.navigationmange.dao;

import com.alibaba.fastjson.JSONObject;
import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardRepositoryTest {

    @Resource
    CardGroupRepository cardGroupRepository;

    @Resource
    CardRepository cardRepository;

    /**
     * 添加部分
     */
    @Test
    public void testAdd(){



    }


    public List<Card> getTestCards(){
        List<Card> datas = new ArrayList<>();
        Card card = new Card();
//        card.setName("哈里哈利");
//        jsonObject.put("name","哈里哈利");
//        jsonObject.put("id","哈里哈利");
//        jsonObject.put("url","halihali.li/");
//        jsonObject.put("description","在线观看各类视频");
//        jsonObject.put("img","http://www.xinmove.com/image/uploadpic/xinmove_com_halihali46asdwda456a74w6.png");
//        datas.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("name","扫把博客");
//        jsonObject.put("id","扫把博客");
//        jsonObject.put("url","blog.xinmove.com");
//        jsonObject.put("description","扫把的博客");
//        jsonObject.put("img","http://www.xinmove.com/image/title-logo.png");
//        datas.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("name","百度");
//        jsonObject.put("id","百度");
//        jsonObject.put("url","www.baidu.com");
//        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
//        jsonObject.put("img","https://www.baidu.com/favicon.ico");
//        datas.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("name","百度2");
//        jsonObject.put("id","百度2");
//        jsonObject.put("url","www.baidu.com");
//        jsonObject.put("description","百度搜索，玩的噶UI的哈达哈斯");
//        jsonObject.put("img","https://www.baidu.com/favicon.ico");
//        datas.add(jsonObject);

        return null;
    }

}
