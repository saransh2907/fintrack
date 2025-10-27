package com.trackfin.fintrack.service;


import com.trackfin.fintrack.config.JwtUtil;
import com.trackfin.fintrack.enitity.User;
import com.trackfin.fintrack.model.AuthResponse;
import com.trackfin.fintrack.model.LoginRequest;
import com.trackfin.fintrack.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.webauthn.api.AuthenticatorResponse;
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

//    public AuthenticatorResponse register(Usre req) {
//        if (userRepository.existsByEmail(req.getEmail())) {
//            throw new RuntimeException("Email already exists");
//        }
//        User u = User.builder()
//                .name(req.getName())
//                .email(req.getEmail().toLowerCase().trim())
//                .passwordHash(passwordEncoder.encode(req.getPassword()))
//                .build();
//        userRepository.save(u);
//        String token = jwtUtil.generateToken(u.getEmail());
//        return new AuthResponse(token);
//    }

    public AuthResponse login(LoginRequest req) {
        User u = userRepository.findByEmail(req.getEmail().toLowerCase().trim())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(req.getPassword(), passwordEncoder.encode(u.getPassword()))) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(u.getEmail());
        return new AuthResponse(token);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}