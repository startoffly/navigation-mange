package com.xinmove.navigationmange;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;
import com.xinmove.navigationmange.service.CardService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.*;

@EnableJpaAuditing
@SpringBootApplication
public class NavigationMangeApplication {

    private static final Logger logger = LogManager
            .getLogger(NavigationMangeApplication.class);

    //打包时
    @Bean
    InitializingBean saveData(CardGroupService cardGroupService, CardService cardService){
        return ()->{
            if (cardGroupService.count()==0&&cardService.count()==0){
                System.out.println("未检测到数据，进入初始化...");
                //初始化些测试数据
                CardGroup cardGroup0 = new CardGroup("默认分组","fa fa-clone","这是一个默认分组",0,0);
                CardGroup cardGroup1 = new CardGroup("我的项目","fa fa-hand-peace-o","我的项目",0,1);
                CardGroup cardGroup2 = new CardGroup("高频使用","fa fa-free-code-camp","高频使用",0,1);
                cardGroupService.saveCardGroup(cardGroup0);
                cardGroupService.saveCardGroup(cardGroup1);
                cardGroupService.saveCardGroup(cardGroup2);

                List<CardGroup> groupsD = new ArrayList<>();
                for (int i = 1; i < 4; i++) {
                    groupsD.add(cardGroupService.findOne(i).get());
                }
                List<Card> cards = new ArrayList<>();
                cards.add(new Card("星幕之家","扫把的个人站","http://www.xinmove.com","http://www.xinmove.com/favicon.ico",0,0,groupsD));
                cards.add(new Card("百度","百度充填","http://www.baidu.com","https://www.baidu.com/favicon.ico",0,0,groupsD));
                cardService.saveCardAll(cards);
            }else {
                logger.info("检测到已有数据，跳过初始化");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(NavigationMangeApplication.class, args);
    }

}
