package com.manthan.demo.service.implementation;

import com.manthan.demo.DTO.UserDTO;
import com.manthan.demo.Mapper.UserMapper;
import com.manthan.demo.exception.UserNotFoundException;
import com.manthan.demo.model.User;
import com.manthan.demo.repo.Userrepo;
import com.manthan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserImp implements UserService {

    @Autowired
    private Userrepo repo;

    @Override
    public List<UserDTO> getalluser() {
        return repo.findAll()
                .stream()
                .map(UserMapper::todto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createnewuser(UserDTO dto) {
        User user = UserMapper.toentity(dto);
        User saved = repo.save(user);
        return UserMapper.todto(saved);
    }

    @Override
    public UserDTO getUserById(long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        return UserMapper.todto(user);
    }

    @Override
    public UserDTO UpdateUser(Long id, UserDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User saved = repo.save(user);
        return UserMapper.todto(saved);
    }

    @Override
    public void deleteuser(long id) {
        repo.deleteById(id);
    }
}



