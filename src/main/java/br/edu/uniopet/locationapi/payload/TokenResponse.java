package br.edu.uniopet.locationapi.payload;

import br.edu.uniopet.locationapi.model.account.Account;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TokenResponse {
    private String tokenType = "Bearer";

    @NonNull
    private String accessToken;

    @NonNull
    private Account account;
}
