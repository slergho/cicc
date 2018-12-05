package com.gh.cicc.mapper;

import com.gh.cicc.model.Insurance;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository

public class InsuranceMapper {
    //查询数据
    @Select("SELECT * FROM USER WHERE PHONE = #{phone}")
    Insurance findUserByPhone(@Param("phone") String phone);
    //添加数据
    @Insert("INSERT INTO USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);


}
