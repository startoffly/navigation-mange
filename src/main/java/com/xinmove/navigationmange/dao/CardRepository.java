package com.xinmove.navigationmange.dao;

import com.xinmove.navigationmange.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    /**
     *
     * @param cardGroupId
     * @param hide
     * @return
     */
    List<Card> findByCardGroup_IdAndHideOrderByRankDesc(Integer cardGroupId,Integer hide);



    Optional<Card> findByName(String name);

    @Override
    Optional<Card> findById(Long id);

    @Override
    void deleteAll();
}
