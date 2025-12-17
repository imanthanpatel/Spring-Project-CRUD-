package com.manthan.demo.repo;

import com.manthan.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Userrepo extends JpaRepository<User, Long > {
}
