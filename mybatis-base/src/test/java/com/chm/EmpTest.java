package com.chm;

import com.chm.entity.Emp;
import com.chm.entity.Employee;
import com.chm.mapper.EmpMapper;
import com.chm.mapper.EmployeeMapper;
import com.chm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EmpTest {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper emp = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptByEid = emp.getEmpAndDeptByEid(3);
        System.out.println(empAndDeptByEid);

    }
}
