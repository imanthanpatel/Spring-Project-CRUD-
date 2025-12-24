package com.manthan.demo.DTO;


import com.manthan.demo.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String email;
    private String password;
    private List<Address> addresses;


}
