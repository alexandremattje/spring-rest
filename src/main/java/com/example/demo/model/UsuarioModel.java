package com.example.demo.model;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioAutenticado;
import com.example.demo.model.jpa.User;
import com.example.demo.model.repository.UserRepository;

@Service
public class UsuarioModel implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UsuarioAutenticado(user);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
}
