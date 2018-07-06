package com.config.security.service;

import com.config.security.model.UsuarioSistema;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class LoginService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {       
        Collection<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USUARIO"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_VISUALIZAR_RELATORIO_CUSTOS"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_VISUALIZAR_RELATORIO_EQUIPE"));
        return new UsuarioSistema("Operador do Sistema", "admin", "$2a$16$YvxGHY9USx26KHULvSabVu.PP.VdQJ5ovSpfhPD1geY4Icn7/jFJq", grantedAuthorityList);
    }

    
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder(16).encode("123"));
//    }
}
