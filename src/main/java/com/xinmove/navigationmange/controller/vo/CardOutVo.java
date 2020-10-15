package com.xinmove.navigationmange.controller.vo;

import com.xinmove.navigationmange.entity.Card;
import lombok.Data;

/**
 * @Auther: startoffly
 * @Date: 2020/10/14 20:31
 * @Description: 展示给前端的卡字段
 */
@Data
public class CardOutVo {

    private Long id;

    private String name;

    private String description;

    private String url;

    private String img;

    private int rank;

    public CardOutVo(Card card) {
        this.id = card.getId();
        this.name = card.getName();
        this.description = card.getDescription();
        this.url = card.getUrl();
        this.img = card.getImg();
        this.rank = card.getRank();
    }
}
