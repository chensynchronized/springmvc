package com.chm;

import com.chm.entity.Employee;
import com.chm.mapper.EmployeeMapper;
import com.chm.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class employeeTest {
    @Test
    public void test1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//            sqlSessionFactory.getConfiguration().addMapper(Employee.class);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee empAndDeptById = employeeMapper.getEmpAndDeptById(2);
            System.out.println(empAndDeptById);
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
