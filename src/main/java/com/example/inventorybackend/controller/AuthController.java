//package com.example.inventorybackend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.example.inventorybackend.model.User;
//import com.example.inventorybackend.service.AuthService;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user) {
//        // Validate user credentials
//        String token = authService.login(user.getEmail(), user.getPassword());
//        if (token != null) {
//            return ResponseEntity.ok(token); // Return JWT token on successful login
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return 401 Unauthorized if login fails
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user) {
//        // Register new user
//        boolean success = authService.register(user);
//        if (success) {
//            return ResponseEntity.ok().build(); // Return 200 OK on successful registration
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Return 400 Bad Request if registration fails
//        }
//    }
//
//    @PostMapping("/recover-password")
//    public ResponseEntity<?> recoverPassword(@RequestBody User user) {
//        // Handle password recovery
//        boolean success = authService.recoverPassword(user.getEmail());
//        if (success) {
//            return ResponseEntity.ok().build(); // Return 200 OK if password recovery is initiated successfully
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 Not Found if user is not found
//        }
//    }
//}
