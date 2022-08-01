package com.zht.spring.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("coach")
public class coach {
    @TableId(type = IdType.AUTO)
    public Integer id;

    public Integer age,work ,isclass ;
    public String name,sex, photo,evaluate;
    public Date createDate;
    public Date modDate;
    public double height,weight,cost;
}
