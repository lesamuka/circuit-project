package com.appweb.agenda.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AgendaMb implements Serializable {

    private static final long serialVersionUID = -2753121484297994226L;
    
    

    @PostConstruct
    private void init() {

    }

}