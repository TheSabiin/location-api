package br.edu.uniopet.locationapi.controller.account;

import br.edu.uniopet.locationapi.model.account.Account;
import br.edu.uniopet.locationapi.payload.LoginRequest;
import br.edu.uniopet.locationapi.payload.TokenResponse;
import br.edu.uniopet.locationapi.security.JwtTokenProvider;
import br.edu.uniopet.locationapi.service.account.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Resource
    private AccountService accountService;

    @Resource
    private JwtTokenProvider tokenProvider;

    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<Account> signUp(@RequestBody Account account) {
        Account createdAccount = accountService.signup(account);

        return ResponseEntity.created(null).body(createdAccount);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String loginUser = loginRequest.getUsername();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        Account account = (Account) accountService.loadUserByUsername(loginUser);

        return ResponseEntity.ok(new TokenResponse(jwt, account));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        accountService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
