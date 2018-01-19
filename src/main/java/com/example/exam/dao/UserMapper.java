package com.example.exam.dao;

import com.example.exam.MutiDataSourceConfig.DataSourceConfig;
import com.example.exam.MutiDataSourceConfig.DataSourceKey;
import com.example.exam.annotation.MutiDataSource;
import com.example.exam.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectUserById(String id);


    User queryUserByName(@Param("userName") String username, @Param("password") String password);

    @MutiDataSource(name= DataSourceKey.slave)
    User selectUserByName(@Param("userName") String username);
}
