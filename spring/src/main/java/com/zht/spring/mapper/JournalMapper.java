package com.zht.spring.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.spring.pojo.journal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JournalMapper extends BaseMapper<journal>{
    List<journal> selectjournal();
    @Select("select * from journal where userid = #{id}")
    List<journal> selectByuserid(int id);
    @Insert("insert into journal (userid,createdate,content) value (#{userid},#{createdate},#{content})")
    void myinsert(journal journal);
}
