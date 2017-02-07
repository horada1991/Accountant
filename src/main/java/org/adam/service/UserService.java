package org.adam.service;

import org.adam.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
