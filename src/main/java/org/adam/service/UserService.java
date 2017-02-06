package org.adam.service;

import org.adam.model.User;

/**
 * Created by Cerianth on 2017.02.06..
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
