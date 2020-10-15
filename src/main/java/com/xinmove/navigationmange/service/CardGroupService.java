package com.xinmove.navigationmange.service;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;

import java.util.Optional;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 20:34
 * @Description:
 */
public interface CardGroupService {

    long count();

    Optional<CardGroup> findOne(int gid);

    /**
     * 添加一个分组
     * @param cardGroup
     */
    void saveCardGroup(CardGroup cardGroup);

    /**
     * 置顶
     * @param gid
     */
    void pushCardGroupTop(int gid);

    /**
     * 交换两个card的rank
     * @param cardGroupId1 组id1
     * @param cardGroupId2 组id2
     */
    void exchangeCardGroupRank(Integer cardGroupId1,Integer cardGroupId2);
}
