package com.xinmove.navigationmange.dao;

import com.xinmove.navigationmange.entity.Card;
import com.xinmove.navigationmange.entity.CardGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardGroupRepository extends JpaRepository<CardGroup,Integer> {

    @Override
    Optional<CardGroup> findById(Integer id);

    @Override
    void deleteAll();
}
