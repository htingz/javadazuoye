package com.zht.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.spring.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<user> {
    @Select("select * from user")
    List<user> selectuser();

//    user selectById(int id);

 //   int insertuser(user user);

    @Select("select * from user where username = #{username}")
    user selectByname(String username);
    @Update("update user set coach = 1 where name = #{name}")
    void updatecoach(String name);
    @Select("select id from user where username = #{name}")
    int selectid(String name);

//    int updatebyid(user user);

//    int deleteById(int id);
//    int selectByName(String name);
//    int count();
}
