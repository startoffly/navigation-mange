package com.xinmove.navigationmange.controller.vo;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * @Auther: startoffly
 * @Date: 2020/10/14 23:30
 * @Description: 展示给前台对外的组字段
 */
@Data
public class CardGroupOutVo {

    private Integer gid;
    /**
     * 组名
     */
    private String name;
    /**
     * 组小图标 如 fa fa-hand-peace-o
     */
    private String icon;
    /**
     * 不隐藏 0，隐藏1
     */
    private int hide;
    /**
     * 组简介
     */
    private String description;

    /**
     * 排序
     */
    private int rank;

    private List<CardOutVo> cardList;

    public CardGroupOutVo(int hide) {
        this.hide = hide;
    }

    public CardGroupOutVo(CardGroup cardGroup) {
        this.gid = cardGroup.getGid();
        this.name = cardGroup.getName();
        this.icon = cardGroup.getIcon();
        this.hide = cardGroup.getHide();
        this.description = cardGroup.getDescription();
        this.rank = cardGroup.getRank();
        List<CardOutVo> cardVos = new ArrayList<>();
        if (nonNull(cardGroup.getCardList())){
            for (Card card : cardGroup.getCardList()) {
                if (card.getHide()<1){//只展示不隐藏的导航卡
                    cardVos.add(new CardOutVo(card));
                }
            }
        }
        this.cardList = cardVos;
    }
}
