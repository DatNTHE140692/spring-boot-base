package vn.edu.fpt.library.services.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.edu.fpt.library.services.jwt.JWTService;
import vn.edu.fpt.library.requests.AuthRequest;
import vn.edu.fpt.library.responses.AuthResponse;
import vn.edu.fpt.library.responses.DefaultResponse;

@Slf4j
@RequiredArgsConstructor
@Service(AuthenticationService.SERVICE_NAME)
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public DefaultResponse<AuthResponse> authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return DefaultResponse.success(AuthResponse.of(jwtService.generateToken(request.getUsername())));
    }

}
