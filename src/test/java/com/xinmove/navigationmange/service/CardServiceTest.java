package com.xinmove.navigationmange.service;

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
public class CardServiceTest {

    @Resource
    CardGroupService cardGroupService;

    @Resource
    CardService cardService;

    @Test
    public void initTest(){
        //初始化些测试数据
        CardGroup cardGroup0 = new CardGroup(1,"默认分组","fa fa-clone","这是一个默认分组",0,0);
        CardGroup cardGroup1 = new CardGroup(2,"我的项目","fa fa-hand-peace-o","我的项目",0,1);
        CardGroup cardGroup2 = new CardGroup(3,"高频使用","fa fa-free-code-camp","高频使用",0,1);
        cardGroupService.saveCardGroup(cardGroup0);
        cardGroupService.saveCardGroup(cardGroup1);
        cardGroupService.saveCardGroup(cardGroup2);
        List<CardGroup> groupsD = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            groupsD.add(cardGroupService.findOne(i).get());
        }
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("星幕之家","扫把的个人站","www.xinmove.com","www.xinmove.com/favicon.ico",0,0,groupsD));
        cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,groupsD));
        cardService.saveCardAll(cards);
    }


}
