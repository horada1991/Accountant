package org.adam.service;

/**
 * Created by Cerianth on 2017.02.06..
 */
public interface SecurityService {
    public String findLoggedInUsername();
    public void autoLogin(String username, String password);
}
