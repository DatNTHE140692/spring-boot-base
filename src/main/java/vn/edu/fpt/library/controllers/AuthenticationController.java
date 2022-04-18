package vn.edu.fpt.library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.fpt.library.configs.AppConfig;
import vn.edu.fpt.library.requests.AuthRequest;
import vn.edu.fpt.library.responses.AuthResponse;
import vn.edu.fpt.library.responses.DefaultResponse;
import vn.edu.fpt.library.services.auth.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConfig.API_PATH + "/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<DefaultResponse<AuthResponse>> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }

}
