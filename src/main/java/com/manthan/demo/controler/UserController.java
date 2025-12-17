package com.manthan.demo.controler;

import com.manthan.demo.DTO.UserDTO;
import com.manthan.demo.model.User;
import com.manthan.demo.service.UserService;
import com.manthan.demo.service.implementation.UserImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserImp userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> user =  userService.getalluser();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @PostMapping("/user/create")
    public ResponseEntity<UserDTO>  createuser(@RequestBody UserDTO dto){
        UserDTO createdUser = userService.createnewuser(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)   // 201 Created
                .body(createdUser);
    }

    @PostMapping("/user/get/{id}")
    public ResponseEntity<UserDTO> getuserbyid(@PathVariable long id){
        UserDTO user = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<UserDTO> updateuser(
            @PathVariable long id,
            @RequestBody UserDTO dto
    ){
        UserDTO service =  userService.UpdateUser( id, dto);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service);
    }
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteuser(@PathVariable long id){
         userService.deleteuser(id);
        ResponseEntity<String> userDeleted = ResponseEntity.ok("User Deleted");
        return userDeleted;
    }
}
