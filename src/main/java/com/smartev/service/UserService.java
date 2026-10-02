package com.smartev.service;

import com.smartev.exception.*;
import com.smartev.model.*;
import com.smartev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired private EVUserRepository userRepo;

    public List<EVUser> getAllUsers() { return userRepo.findAll(); }
    public EVUser getUserById(Long id) { return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found")); }
    public EVUser saveUser(EVUser user) { return userRepo.save(user); }
    public void deleteUser(Long id) { userRepo.deleteById(id); }
    public EVUser authenticate(String email, String password) {
        EVUser user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
