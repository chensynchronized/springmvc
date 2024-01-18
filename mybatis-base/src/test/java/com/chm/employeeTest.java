package com.chm;

import com.chm.entity.Emp;
import com.chm.entity.Employee;
import com.chm.mapper.EmployeeMapper;
import com.chm.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class employeeTest {

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = emp.getEmployeeById(3);
        System.out.println(employee);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = emp.getEmployeeByName("zhangsan");
        System.out.println(employee);
    }
    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = emp.getEmployeeByIdAndName(3, "wangwu");
        System.out.println(employee);
    }
    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("empId",3);
        map.put("empName","wangwu");
        Employee employee = emp.getEmployeeByMap(map);
        System.out.println(employee);
    }
    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Employee admin = new Employee(null, "admin", 26, "99874@qq.com", 2);
        int i = emp.addEmployee(admin);
        System.out.println(i);
    }
    @Test
    public void test7(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = emp.getEmployee(9);
        System.out.println(employee);
    }
    @Test
    public void test8(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = emp.getAllEmployee();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    @Test
    public void test9(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Map<String, Object> employeeByMap = emp.getEmployeeToMap(9);
        System.out.println(employeeByMap);

    }
    @Test
    public void test10(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        List<Map<String, Object>> employeeToMapList = emp.getEmployeeToMapList();
        for (Map<String, Object> stringObjectMap : employeeToMapList) {
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test11(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        Map<Integer, Map<String, Object>> employeeToMapMap = emp.getEmployeeToMapMap();
        System.out.println(employeeToMapMap);
    }
    @Test
    public void test12(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeLike = emp.getEmployeeLike("a");
        System.out.println(employeeLike);

    }

}
