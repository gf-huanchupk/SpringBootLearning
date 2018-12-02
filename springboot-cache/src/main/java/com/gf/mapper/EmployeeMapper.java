package com.gf.mapper;

import com.gf.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gf
 * @since 2018-11-25
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
