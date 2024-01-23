package com.chm.mapper;

import com.chm.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<Employee> getEmpListByCondition(Employee emp);

    int insertEmployeeByForeach(List<Employee> list);

}
