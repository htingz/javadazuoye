package com.zht.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<user> {
    List<user> selectuser();

//    user selectById(int id);

 //   int insertuser(user user);

    @Select("select * from user where username = #{username}")
    user selectByname(String username);

//    int updatebyid(user user);

//    int deleteById(int id);
//    int selectByName(String name);
//    int count();
}
