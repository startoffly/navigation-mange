package com.xinmove.navigationmange.service;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;

import java.util.List;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 20:21
 * @Description:
 */
public interface CardService {

    /**
     * 添加一张导航卡
     * @param card
     */
    void saveCard(Card card);

    void saveCardAll(List<Card> cards);

    /**
     * 根据id覆盖更新一张导航卡
     * @param card
     * @return
     */
    int updateCardById(Card card);

    /**
     * 修改导航卡的分组
     * @param cardId
     * @param cardGroup
     * @return
     */
    int updateCardAboutCardGroupById(Long cardId,CardGroup cardGroup);

    /**
     * 置顶
     * @param cardId1
     */
    void pushCardTop(Long cardId1);

    /**
     * 交换两个card的rank
     * @param cardId1
     * @param cardId2
     */
    void exchangeCardRank(Long cardId1,Long cardId2);


}
