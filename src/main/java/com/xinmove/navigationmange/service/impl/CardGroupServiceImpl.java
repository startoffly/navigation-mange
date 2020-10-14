package com.xinmove.navigationmange.service.impl;

import com.xinmove.navigationmange.dao.CardGroupRepository;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 21:40
 * @Description:
 */
public class CardGroupServiceImpl implements CardGroupService {

    @Resource
    CardGroupRepository cardGroupRepository;

    @Override
    public void saveCardGroup(CardGroup cardGroup) {
        cardGroup.setRank(cardGroupRepository.findMaxRank());
        cardGroupRepository.save(cardGroup);
    }

    @Transactional
    @Override
    public void pushCardGroupTop(int cardGroupId) {
        int maxRank = cardGroupRepository.findMaxRank();
        cardGroupRepository.updateCardGroupRankById(cardGroupId,cardGroupId);
    }

    @Override
    public void exchangeCardGroupRank(Long cardGroupId1, Long cardGroupId2) {

    }
}
