package com.trackfin.fintrack.service;

import com.trackfin.fintrack.enitity.User;
import com.trackfin.fintrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> getAllUsers(Pageable page){
        return repository.findAll(page);
    }
}
