package com.ryan.xunwu.repository;

import com.ryan.xunwu.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @ClassName RoleRepository
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 17:18
 * @Version 1.0
 **/

public interface RoleRepository extends CrudRepository<Role,Long>{
    List<Role> findRoleByUserId(Long userId);
}
