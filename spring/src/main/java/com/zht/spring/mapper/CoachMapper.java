package com.zht.spring.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.spring.pojo.coach;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CoachMapper extends BaseMapper<coach>{
    List<coach> selectcoach();
    @Insert("INSERT INTO coach  ( sex,photo ,age, work, isclass, name,   evaluate, createDate, modDate, height, weight, cost )  VALUES  (#{sex},#{photo}, #{age}, #{work}, #{isclass}, #{name},   #{evaluate}, #{createDate},#{modDate}, #{height}, #{weight}, #{cost})")
    void myinsert(coach coach);

    @Select("select * from coach where name = #{name}")
    coach selectByname(String name);
    @Update("update coach set age = #{age} ,height = #{height},weight = #{weight},work = #{work} ,isclass = #{isclass} ,cost = #{cost},modDate = #{modDate}  where name = #{name} ")
    void updateByName(coach coach);

    @Select("select id from coach where name = #{name}")
    int selectid(String name);
    @Update("update coach set isclass = 1 where name = #{name}")
    void updateisclass(String name);
}
