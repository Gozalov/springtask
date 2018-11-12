package com.demo.service;

import com.demo.model.User;

public interface UserService {
    User findById(int userId);

    void deleteById(int userId);

    void saveOrUpdate(User user);
}
