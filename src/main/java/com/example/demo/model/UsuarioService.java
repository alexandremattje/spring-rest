package com.example.demo.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDetailsImpl;
import com.example.demo.dto.UsuarioAutenticado;
import com.example.demo.model.jpa.User;
import com.example.demo.model.repository.UserRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsImpl(user);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    public UsuarioAutenticado autenticar(String username, String senha) {
        User user = this.repository.findByLogin(username);

        if (user.getSenha().equals(senha)) {
            String token = tokenService.autenticar(user.getLogin(), user.getAdministrador());

            return UsuarioAutenticado.builder()
                    .administrador(user.getAdministrador())
                    .autenticado(Boolean.TRUE)
                    .login(user.getLogin())
                    .token(token)
                    .nome(user.getNome())
                    .build();
        } else {
            return UsuarioAutenticado.builder()
                    .nome(user.getNome())
                    .login(user.getLogin())
                    .build();
        }

    }

}
