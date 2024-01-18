package com.chm.mapper;

import com.chm.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    Employee getEmpAndDeptById(@Param("empId") Integer empId);
}
