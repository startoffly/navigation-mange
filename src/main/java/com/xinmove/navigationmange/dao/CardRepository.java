package com.xinmove.navigationmange.dao;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    /**
     * 获取一个组 的导航卡
     * @param cardGroupId 组id
     * @param hide 是否隐藏
     * @return
     */
    List<Card> findByCardGroup_GidAndHideOrderByRankDesc(Integer cardGroupId,Integer hide);

    /**
     * 获取当前最大rank
     * @return
     */
    @Query("SELECT MAX(c.rank) from  Card c")
    int findMaxRank();

    Optional<Card> findByName(String name);

    @Override
    Optional<Card> findById(Long id);

    @Override
    void deleteAll();

    /**
     * 更改导航卡的分组
     * @param id 卡id
     * @param cardGroup 卡分组
     */
    @Transactional
    @Modifying
    @Query("UPDATE Card c SET c.cardGroup = ?2 WHERE c.id = ?1")
    int updateCardCardGroupTypeById(Long id, CardGroup cardGroup);

    /**
     * @param id 卡id
     * @param rank 排序
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE Card c SET c.rank = ?2 WHERE c.id = ?1")
    int updateCardRankById(Long id,int rank);

}
