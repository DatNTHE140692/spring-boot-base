package vn.edu.fpt.library.services.auth;

import vn.edu.fpt.library.requests.AuthRequest;
import vn.edu.fpt.library.responses.AuthResponse;
import vn.edu.fpt.library.responses.DefaultResponse;

public interface AuthenticationService {

    String SERVICE_NAME = "AuthenticationService";

    DefaultResponse<AuthResponse> authenticate(AuthRequest authRequest);

}
