package com.trackfin.fintrack.user.service;


import com.trackfin.fintrack.user.config.JwtUtil;
import com.trackfin.fintrack.user.model.LoginRequest;
import com.trackfin.fintrack.user.model.RegisterRequest;
import com.trackfin.fintrack.user.enitity.User;
import com.trackfin.fintrack.user.model.AuthResponse;
import com.trackfin.fintrack.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse register(RegisterRequest req) {
        if ( userRepository.findByEmail(req.getEmail()).isPresent() ) {
            throw new RuntimeException("Email already exists");
        }
        User u = User.builder()
                .name(req.getUserName())
                .email(req.getEmail().toLowerCase().trim())
                .contact(req.getContact())
                .password(passwordEncoder.encode(req.getPassword()))
                .isActive(true)
                .build();
        userRepository.save(u);
        String token = jwtUtil.generateToken(u.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest req) {
        User u = userRepository.findByEmail(req.getEmail().toLowerCase().trim())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if( !u.getIsActive()){
            return new AuthResponse("User Inactive");
        }
        if (!passwordEncoder.matches(req.getPassword(), u.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(u.getEmail());
        return new AuthResponse(token);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(User u) {
        u.setIsActive(false);
        userRepository.save(u);
    }
}