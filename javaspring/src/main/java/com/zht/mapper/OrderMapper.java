package com.zht.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.pojo.coach;
import com.zht.pojo.order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<order>{
    List<order> selectorder();
}
