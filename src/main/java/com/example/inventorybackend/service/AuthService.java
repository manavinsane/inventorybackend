//package com.example.inventorybackend.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.inventorybackend.model.User;
//import com.example.inventorybackend.repository.UserRepository;
//import com.example.inventorybackend.security.JwtTokenUtil;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    public String login(String email, String password) {
//        // Authenticate user
//        User user = userRepository.findByEmailAndPassword(email, password);
//        if (user != null) {
//            // Generate JWT token
//            return jwtTokenUtil.generateToken(user);
//        } else {
//            return null;
//        }
//    }
//
//    public boolean register(User user) {
//        // Check if user already exists
//        if (userRepository.findByEmail(user.getEmail()) == null) {
//            // Register new user
//            userRepository.save(user);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean recoverPassword(String email) {
//        // Implement password recovery logic here
//        return true; // Placeholder implementation, actual logic may vary
//    }
//}
