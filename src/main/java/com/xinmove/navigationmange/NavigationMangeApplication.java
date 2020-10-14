package com.xinmove.navigationmange;

import com.xinmove.navigationmange.dao.CardGroupRepository;
import com.xinmove.navigationmange.dao.CardRepository;
import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class NavigationMangeApplication {

    //打包时
//    @Bean
    InitializingBean saveData(CardGroupService cardGroupService){
        return ()->{
            //初始化些测试数据
            CardGroup cardGroup0 = new CardGroup(0,"默认分组","fa fa-clone","这是一个默认分组",0,0);
            CardGroup cardGroup1 = new CardGroup(1,"我的项目","fa fa-hand-peace-o","我的项目",0,1);
            CardGroup cardGroup2 = new CardGroup(2,"高频使用","fa fa-free-code-camp","高频使用",0,1);
            cardGroupService.saveCardGroup(cardGroup0);
            cardGroupService.saveCardGroup(cardGroup1);
            cardGroupService.saveCardGroup(cardGroup2);

            List<Card> cards = new ArrayList<>();
            cards.add(new Card("星幕之家","扫把的个人站","www.xinmove.com","www.xinmove.com/favicon.ico",0,0,cardGroup0));
            cards.add(new Card("星幕之家","扫把的个人站","www.xinmove.com","www.xinmove.com/favicon.ico",0,0,cardGroup1));
            cards.add(new Card("星幕之家","扫把的个人站","www.xinmove.com","www.xinmove.com/favicon.ico",0,0,cardGroup2));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));
            cards.add(new Card("百度","百度充填","www.baidu.com",null,0,0,cardGroup0));





        };
    }

    public static void main(String[] args) {
        SpringApplication.run(NavigationMangeApplication.class, args);
    }

}
