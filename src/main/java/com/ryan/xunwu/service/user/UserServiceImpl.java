package com.ryan.xunwu.service.user;

import com.ryan.xunwu.entity.Role;
import com.ryan.xunwu.entity.User;
import com.ryan.xunwu.repository.RoleRepository;
import com.ryan.xunwu.repository.UserRepository;
import com.ryan.xunwu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 17:08
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);

        if(user == null){
            return null;
        }

        List<Role> roles = roleRepository.findRoleByUserId(user.getId());
        if(roles == null || roles.isEmpty()){
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorities(authorities);
        return user;

    }
}
