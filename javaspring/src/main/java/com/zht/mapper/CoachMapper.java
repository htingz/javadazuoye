package com.zht.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.pojo.coach;
import com.zht.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoachMapper extends BaseMapper<coach>{
    List<coach> selectcoach();

    @Select("select * from coach where username = #{username}")
    coach selectByname(String username);
}
