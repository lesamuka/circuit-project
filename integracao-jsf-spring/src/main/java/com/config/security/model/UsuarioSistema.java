package com.config.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioSistema extends User {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String username;
    private String password;
    private List<Role> roles = new ArrayList<>();
    
//    private Collection<GrantedAuthority> authorities;

    public UsuarioSistema(String nome, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.roles = (List<Role>) authorities;
    }

    public String getNome() {
        return nome;
    }
}
