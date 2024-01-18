package com.chm.mapper;

import com.chm.entity.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    Emp getEmpAndDeptByEid(@Param("id") int empId);
}
