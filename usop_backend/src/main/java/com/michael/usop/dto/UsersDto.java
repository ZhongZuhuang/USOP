package com.michael.usop.dto;

import com.michael.usop.entity.Users;
import lombok.Data;

@Data
public class UsersDto {
    public String username;
    public Integer age;
    public String school;
    public String hobbies;
    public String sex;

    public Users DtUo(){
        Users users = new Users();
        users.setUsername(username);
        users.setAge(age);
        users.setHobbies(hobbies);
        users.setSchool(school);
        users.setSex(sex);
        return users;
    }

}
