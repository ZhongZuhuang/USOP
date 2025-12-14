package com.michael.usop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class Users {
    @TableId(type = IdType.AUTO) // 声明主键，类型为自增（与数据库表主键策略一致）
    private Integer id;

    private String username;
    private Integer age;
    private String school;
    private String hobbies;
    private String sex;
}

/*这个类为实体类，主要用于承载一张表，将表数据转换为对象
* 采用了Mybatis-Plus的@TableName注解,将表名与对象绑定，使得不用手动配置
* @Data注解使类继承getter/setter方法，为lombok自动继承
* */
