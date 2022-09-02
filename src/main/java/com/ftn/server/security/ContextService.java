package com.ftn.server.security;

import com.ftn.server.model.Korisnik;
import com.ftn.server.repository.KorisnikRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContextService {

    public static Optional<Korisnik> getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if ((authentication != null) && (authentication.getPrincipal() instanceof Korisnik)) {
            return Optional.of((Korisnik) authentication.getPrincipal());
        }
        return Optional.empty();
    }
}
