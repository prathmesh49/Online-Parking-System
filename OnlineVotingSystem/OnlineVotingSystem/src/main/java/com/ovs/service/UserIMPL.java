package com.ovs.service;

import com.ovs.Exception.NotFoundException;
import com.ovs.model.User;
import com.ovs.repository.UserRepository;
import com.ovs.serviceIF.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserIMPL implements UserSrv {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(int userid) {
        Optional<User> opt = userRepository.findById(userid);
        if (opt.isEmpty()) throw new NotFoundException("user not found for this " + userid);
        return opt.get();
    }
}
