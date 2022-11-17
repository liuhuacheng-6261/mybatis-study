package com.nbury.test;

import com.nbury.entity.User;
import com.nbury.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liuhuacheng
 * @create 2022-11-14 1:23
 */
public class MybatisTest {



    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.insertUser();
//        User user = mapper.getUser(2);
        //多个参数 arg0 arg1 param1 param2 入参是一个map
//        User user = mapper.getUserByUserNameAndPassword("liuhuacheng", "207715");
        //模糊查询concat('%',#{username},'%') '%${}%' "%"#{}"%"
        User user = mapper.getUserLikeByUsername("liu");
        //批量删除只能用${}a
//        int user = mapper.batchDeleteUser("1,2,3");
        //自增主键
//        User user = new User(null, "liuhuacheng", "207715");
//        User user = new User();
//        user.setName("xuke");
//        user.setPassword("985324");
//        mapper.insertUserAutoId(user);
        System.out.println(user);

    }


}
