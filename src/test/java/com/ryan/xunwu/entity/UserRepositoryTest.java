package com.ryan.xunwu.entity;

import com.ryan.xunwu.XunwuProjectApplicationTests;
import com.ryan.xunwu.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserRepositoryTest
 * @Description
 * @Author linzhenhong
 * @Date 2019/3/12 10:33
 * @Version 1.0
 **/
public class UserRepositoryTest extends XunwuProjectApplicationTests{
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        System.out.println("===================");
        System.out.println(user);
        System.out.println("===================");
        System.out.println();
        Assert.assertEquals("xunwu", user.getName());
    }

}
