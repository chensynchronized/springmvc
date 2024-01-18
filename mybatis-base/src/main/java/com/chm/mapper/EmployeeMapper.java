package com.chm.mapper;

import com.chm.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer empId);

    Employee getEmployeeByName(String empName);

    Employee getEmployeeByIdAndName(Integer empId,String empName);

    Employee getEmployeeByMap(Map map);

    int addEmployee(Employee employee);

    Employee getEmployee(@Param("id") Integer empId);

    List<Employee> getAllEmployee();

    Map<String,Object> getEmployeeToMap(Integer empId);

    List<Map<String,Object>> getEmployeeToMapList();
    @MapKey("emp_id")
    Map<Integer,Map<String,Object>> getEmployeeToMapMap();

    List<Employee> getEmployeeLike(String s);
}
