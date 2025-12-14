package com.michael.usop.controller;

import com.michael.usop.dto.UsersDto;
import com.michael.usop.entity.Users;
import com.michael.usop.response.UserResponse;
import com.michael.usop.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class UsersController {

    private final UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public Object GetUser(@PathVariable Integer id){
        return UserResponse.GetUserResponse(userService.getUserById(id));
    }

    @PostMapping("/users")
    public Object InsertUser(@RequestBody UsersDto user){
        Users newUser = user.DtUo();
        return UserResponse.CreateUserResponse(userService.insertUser(newUser));
    }

    @DeleteMapping("/users/{id}")
    public Object DeleteUser(@PathVariable Integer id){
        return UserResponse.DeleteUserResponse(userService.deleteUserById(id));
    }

    @PutMapping("/users/{id}")
    public Object UpdateUser(@PathVariable Integer id,  @RequestBody UsersDto user){
        Users newUser = user.DtUo();
        return UserResponse.UpdateUserResponse(userService.getUserById(id), newUser, userService.updateUserById(id, newUser));
    }
}
