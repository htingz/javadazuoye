package com.zht.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class user {
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer points,program,coach;
    public String username,password ,name,phone,sex,address;

}
