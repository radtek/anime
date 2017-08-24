package com.anmi.anime.domain.authorize.repository;

import com.anmi.anime.domain.authorize.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangjue on 2017/8/22.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByPkId(String pkId);
    List<User> findByName(String name);
    User findByUsernameAndPassword(String userName, String passWord);
    List<User> findByNameContaining(String name);

    @Query(value = "SELECT * FROM gafis_authorize_user t WHERE t.DELTAG = :delTag", nativeQuery = true)
    List<User> findByState1(@Param("delTag") Integer delTag);

    @Query(value = "SELECT t FROM User t WHERE t.deltag = :delTag")
    List<User> findByState(@Param("delTag") Integer delTag);
}