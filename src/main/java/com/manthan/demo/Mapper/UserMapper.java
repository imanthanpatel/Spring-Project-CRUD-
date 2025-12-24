package com.manthan.demo.Mapper;


import com.manthan.demo.DTO.UserDTO;
import com.manthan.demo.model.Address;
import com.manthan.demo.model.User;

public class UserMapper {
    public static UserDTO todto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setAddresses(user.getAddress());
        return dto;
    }

    // DTO → ENTITY
    public static User toentity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
