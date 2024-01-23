package com.chm.test;

import com.chm.entity.Employee;
import com.chm.mapper.EmployeeMapper;
import com.chm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicTest {
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee>list = employeeMapper.getEmpListByCondition(new Employee(null,"zhangsan",18,null,null));
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        ArrayList<Employee> list = new ArrayList<>();
        Employee e1 = new Employee(null,"xiaohong",18,"987456@qq.com",4);
        Employee e2 = new Employee(null,"xiaoli",18,"987456@qq.com",1) ;
        Employee e3 = new Employee(null,"xiaohua",18,"987456@qq.com",3);
        Employee e4 = new Employee(null,"xiaoming",18,"987456@qq.com",2);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        employeeMapper.insertEmployeeByForeach(list);

    }
}
