package com.xinmove.navigationmange.service.impl;

import com.xinmove.navigationmange.dao.CardRepository;
import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import com.xinmove.navigationmange.service.CardService;
import com.xinmove.navigationmange.util.StrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class CardServiceImpl implements CardService {

    @Resource
    CardRepository cardRepository;

    @Override
    public void saveCard(Card card) {
        if (isNull(card.getImg())||card.getImg().isEmpty()){
            card.setImg(StrUtils.getFaviconByUrl(card.getUrl()));
        }
        cardRepository.save(card);
    }

    @Override
    public void saveCardAll(List<Card> cards) {
        for (Card card : cards) {
            if (isNull(card.getImg())||card.getImg().isEmpty()){
                card.setImg(StrUtils.getFaviconByUrl(card.getUrl()));
            }
        }
        cardRepository.saveAll(cards);
    }

    @Override
    public int updateCardById(Card card) {
        try{
            cardRepository.save(card);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateCardAboutCardGroupById(Long cardId, CardGroup cardGroup) {
        try{
            return cardRepository.updateCardCardGroupTypeById(cardId,cardGroup);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void pushCardTop(Long cardId1) {
        int maxRank = cardRepository.findMaxRank();
        cardRepository.updateCardRankById(cardId1,maxRank);
    }

    @Override
    public void exchangeCardRank(Long cardId1, Long cardId2) {
        Optional<Card> card1 = cardRepository.findById(cardId1);
        Optional<Card> card2 = cardRepository.findById(cardId2);
        if (card1.isPresent()&&card2.isPresent()){
            cardRepository.updateCardRankById(card1.get().getId(),card2.get().getRank());
            cardRepository.updateCardRankById(card2.get().getId(),card1.get().getRank());
        }
    }
}
