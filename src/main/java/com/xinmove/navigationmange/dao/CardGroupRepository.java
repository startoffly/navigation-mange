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
public interface CardGroupRepository extends JpaRepository<CardGroup,Integer> {

    Optional<CardGroup> findByGid(Integer id);

    @Override
    void deleteAll();

    void deleteByGid(Integer integer);

    @Query("SELECT COALESCE(MAX(c.rank),0) from  CardGroup c")
    int findMaxRank();

    /**
     * 修改组排序值
     * @param id 组id
     * @param rank 排序字段
     * @return
     */
    @Transactional
    @Modifying
    @Query("UPDATE CardGroup c SET c.rank = ?2 WHERE c.id = ?1")
    int updateCardGroupRankById(int id,int rank);
}
