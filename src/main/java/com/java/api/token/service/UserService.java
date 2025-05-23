package com.java.api.token.service;

import com.java.api.token.dto.UserDTO;
import com.java.api.token.entity.User;
import com.java.api.token.exception.UsuarioInexistenteException;
import com.java.api.token.exception.UsuarioNomeJaExistenteException;
import com.java.api.token.exception.UsuarioNomeObrigatorioException;
import com.java.api.token.model.AuthenticatedUser;
import com.java.api.token.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserDTO userDTO) throws UsuarioNomeJaExistenteException, UsuarioNomeObrigatorioException {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null) {
            throw new UsuarioNomeJaExistenteException();
        };

        if("".equals(userDTO.getUsername())) {
            throw new UsuarioNomeObrigatorioException();
        };

        User u = new User();
        u.setUsername(userDTO.getUsername());
        u.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        return new AuthenticatedUser(u);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void excluir(int id) throws UsuarioInexistenteException {
        User user = userRepository.findByIdUser(id);

        if (user == null) {
            throw new UsuarioInexistenteException();
        }
        userRepository.deleteById(user.getId());
    }
}
