package com.zht.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.pojo.journal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface JournalMapper extends BaseMapper<journal>{
    List<journal> selectjournal();
}
