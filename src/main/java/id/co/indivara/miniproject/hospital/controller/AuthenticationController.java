package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.request.AuthenticationRequest;
import id.co.indivara.miniproject.hospital.dto.request.RegisterRequest;
import id.co.indivara.miniproject.hospital.dto.response.AuthenticationResponse;
import id.co.indivara.miniproject.hospital.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register/doctor")
    public ResponseEntity<AuthenticationResponse> registerDoctor(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerDoctor(request));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}

