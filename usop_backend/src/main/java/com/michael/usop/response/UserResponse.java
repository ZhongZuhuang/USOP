package com.michael.usop.response;

import com.michael.usop.entity.Users;

public class UserResponse {

    public static Object CreateUserResponse(Integer id){
        return new Object(){
            public final String status = "success";
            public final String message = "Created User , id = "+id;
        };
    }

    public static Object DeleteUserResponse(String Username){
        if (Username != null) {
            return new Object() {
                public final String status = "success";
                public final String message = "Deleted User , Username = " + Username;
            };
        }else{
            return new Object() {
                public final String status = "failed";
                public final String message = "User not found";
            };
        }
    }

    public static Object GetUserResponse(Users user){
        if (user != null){
            return new Object(){
            public final String status = "success";
            public final Object user_info = new Object(){
                public final String username = user.getUsername();
                public final Integer age = user.getAge();
                public final String school = user.getSchool();
                public final String hobbies = user.getHobbies();
                public final String sex = user.getSex();
                };
            };
        } else {
            return new Object(){
                public final String status = "failed";
                public final String message = "User not found";
            };
        }
    }

    public static Object UpdateUserResponse(Users before_user,  Users after_user, Integer ID){
        return new Object(){
            public final String status = "success";
            public final Integer id = ID;
            public final Object before = new Object(){
                public final String username = before_user.getUsername();
                public final Integer age = before_user.getAge();
                public final String school = before_user.getSchool();
                public final String hobbies = before_user.getHobbies();
                public final String sex = before_user.getSex();
            };

            public final Object after = new Object(){
                public final String username = after_user.getUsername();
                public final Integer age = after_user.getAge();
                public final String school = after_user.getSchool();
                public final String hobbies = after_user.getHobbies();
                public final String sex = after_user.getSex();
            };
        };
    }

}
