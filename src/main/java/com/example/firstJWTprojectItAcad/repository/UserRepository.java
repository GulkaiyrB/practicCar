package com.example.firstJWTprojectItAcad.repository;

import com.example.firstJWTprojectItAcad.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from user_table WHERE user_name = ?",nativeQuery = true )
    User findByUserName(String username);
}
