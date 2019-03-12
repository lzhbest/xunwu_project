package com.ryan.xunwu.repository;

import com.ryan.xunwu.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByName(String userName);

}
