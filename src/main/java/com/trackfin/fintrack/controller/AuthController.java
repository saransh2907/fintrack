package com.trackfin.fintrack.controller;

import com.trackfin.fintrack.enitity.User;
import com.trackfin.fintrack.model.AuthResponse;
import com.trackfin.fintrack.model.LoginRequest;
import com.trackfin.fintrack.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*@PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        AuthResponse resp = authService.register(request);
        return ResponseEntity.ok(resp);
    }*/

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse resp = authService.login(request);
        return ResponseEntity.ok(resp);
    }

    // Profile endpoint (requires Authorization: Bearer <token>)
    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> me(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User u = authService.getByEmail(email);
        return ResponseEntity.ok(new UserProfileResponse(u.getUserId(), u.getName(), u.getEmail()));
    }

    // DTO for profile response
    public static record UserProfileResponse(Long id, String name, String email) {}
}