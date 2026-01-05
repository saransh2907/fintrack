package com.trackfin.fintrack.user.service;

import com.trackfin.fintrack.user.enitity.User;
import com.trackfin.fintrack.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> getAllUsers(Pageable page){
        return repository.findAll(page);
    }
}
