package br.edu.uniopet.locationapi.service.account;

import br.edu.uniopet.locationapi.model.account.Account;
import br.edu.uniopet.locationapi.repository.account.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User" + username + "not found"));

        return account;
    }

    public Account findById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new UsernameNotFoundException("User" + id + "not found"));

        return account;
    }

    public Account signup(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        return accountRepository.save(account);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
