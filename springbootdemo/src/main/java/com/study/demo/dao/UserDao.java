package com.study.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author: ykfa
 * @Date: 2019/6/6 14:28
 */
@Mapper
public interface UserDao {
    @Select("select * from t_user where id = #{id}")
    Map<String,Object> get(@Param("id") String id);
}
