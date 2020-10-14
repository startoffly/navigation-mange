package com.xinmove.navigationmange.service.impl;

import com.xinmove.navigationmange.dao.CardGroupRepository;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

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

    @Transactional
    @Override
    public void exchangeCardGroupRank(Integer cardGroupId1, Integer cardGroupId2) {
        Optional<CardGroup> cardGroup1 = cardGroupRepository.findByGid(cardGroupId1);
        Optional<CardGroup> cardGroup2 = cardGroupRepository.findByGid(cardGroupId2);
        if (cardGroup1.isPresent()&&cardGroup2.isPresent()){
            cardGroupRepository.updateCardGroupRankById(cardGroup1.get().getGid(),cardGroup2.get().getRank());
            cardGroupRepository.updateCardGroupRankById(cardGroup2.get().getGid(),cardGroup1.get().getRank());
        }

    }
}
