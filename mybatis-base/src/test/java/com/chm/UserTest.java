package com.chm;

import com.chm.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {
    @Test
    public void test1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            UserMapper user = sqlSession.getMapper(UserMapper.class);
            int i = user.insertUser();
            System.out.println(i);
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
