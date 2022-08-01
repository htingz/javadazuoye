package com.zht.spring.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zht.spring.pojo.order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<order>{
    @Select("select * from `order`")
    List<order> selectorder();

    @Select("select * from `order` where username =  #{name}")
    List<order> selectByname(String name);
    @Select("select * from `order` where username = #{username} and coachname = #{coachname}")
    List<order> selectByname2(String username, String coachname);
    @Select("select * from `order` where username =  #{name} and payment = 0")
    List<order> selectByname3(String name);
    @Insert("INSERT INTO `order`  ( userid, coachid, payment,  username, coachname )  VALUES  (#{userid}, #{coachid},#{payment},  #{username}, #{coachname}  )")
    void myinsert(order order);
    @Update("update `order` set payment = 1 where id = #{id}")
    void updatepayment(int id);
    @Select("select COUNT(*) from `order`")
    Integer myselectCount();
    @Update("update `order` set evaluate = #{content} where id = #{id}")
    void updatepingjia(int id, String content);
}
