package com.ws.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create by gl
 * on 2019/3/20
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> , UserRepositoryCustom{

    UserEntity findByUserName(String userName);

}
