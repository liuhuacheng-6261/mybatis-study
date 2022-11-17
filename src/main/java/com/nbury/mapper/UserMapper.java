package com.nbury.mapper;

import com.nbury.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuhuacheng
 * @create 2022-11-14 1:12
 */
public interface UserMapper {


    int insertUser();

    User getUser(Integer id);

    User getUserByUserNameAndPassword(@Param("name") String name, @Param("password") String password);

    User getUserLikeByUsername(@Param("name") String username);

    int batchDeleteUser(@Param("ids") String ids);

    int insertUserAutoId(User user);
}
