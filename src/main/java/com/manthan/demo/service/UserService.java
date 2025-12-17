package com.manthan.demo.service;

import com.manthan.demo.DTO.UserDTO;
import java.util.List;

public interface UserService {

    List<UserDTO> getalluser();
    UserDTO createnewuser(UserDTO dto);
    UserDTO getUserById(long id);   // ✅ FIXED
    UserDTO UpdateUser(Long id, UserDTO dto);
    void deleteuser(long id);
}
