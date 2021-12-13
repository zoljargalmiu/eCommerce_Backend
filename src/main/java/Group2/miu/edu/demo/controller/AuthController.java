package Group2.miu.edu.demo.controller;

import Group2.miu.edu.demo.dto.UserDto;
import Group2.miu.edu.demo.dto.authDTOs.AuthenticationRequest;
import Group2.miu.edu.demo.dto.authDTOs.AuthenticationResponse;
import Group2.miu.edu.demo.repo.UserRepository;
import Group2.miu.edu.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController
{

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepo;


    @PostMapping("/validate")
    public boolean checkTokenValidity(@RequestBody String token){
        return false;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password" , e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

//        final UserDto userData = EntityDtoMapping.userToDtoSingle(userRepo.findByName(authenticationRequest.getName()));

        final UserDto userData = EntityDtoMapping.userToDtoSingle(userRepo.findByUserName(authenticationRequest.getUserName()));

        AuthenticationResponse response = new AuthenticationResponse(jwt, userData);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthneticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password" , e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final UserDto userData = EntityDtoMapping.userToDtoSingle(userRepo.findByUserName(authenticationRequest.getUserName()));

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userData));
    }
}
