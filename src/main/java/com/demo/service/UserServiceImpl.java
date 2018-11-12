package com.demo.service;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }
}
