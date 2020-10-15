package com.xinmove.navigationmange.dao;

import com.xinmove.navigationmange.entity.ManageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManageUserRepository extends JpaRepository<ManageUser,Long> {
}
