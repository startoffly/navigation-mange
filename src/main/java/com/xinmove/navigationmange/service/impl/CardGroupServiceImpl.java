package com.xinmove.navigationmange.service.impl;

import com.xinmove.navigationmange.dao.CardGroupRepository;
import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardGroupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @Auther: startoffly
 * @Date: 2020/10/13 21:40
 * @Description:
 */
@Service
public class CardGroupServiceImpl implements CardGroupService {

    private static final Logger logger = LogManager.getLogger(CardGroupServiceImpl.class);
    @Resource
    CardGroupRepository cardGroupRepository;

    @Override
    public long count() {
        return cardGroupRepository.count();
    }

    @Override
    public Optional<CardGroup> findOne(int gid){
        return cardGroupRepository.findByGid(gid);
    }

    @Override
    public List<CardGroup> findAllOrderByRankDesc() {
        return cardGroupRepository.findAll(Sort.by(Sort.Direction.DESC,"rank"));
    }

    @Override
    public void saveCardGroup(CardGroup cardGroup) {
        cardGroup.setRank(cardGroupRepository.findMaxRank());
        cardGroupRepository.save(cardGroup);
    }

    @Transactional
    @Override
    public void pushCardGroupTop(int cardGroupId) {
        int maxRank = cardGroupRepository.findMaxRank();
        cardGroupRepository.updateCardGroupRankById(cardGroupId,maxRank);
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
