package com.zht.spring.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("order")
public class order {
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer userid,coachid,payment;
    public Integer orderid;
    public String username,coachname,evaluate;
}
