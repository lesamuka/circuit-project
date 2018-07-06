package com.config.principal.perfil.controller;

import com.config.principal.home.service.ClienteService;
import com.config.principal.perfil.model.Perfil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("view")
public class PerfilUsuarioBean implements Serializable {

    private static final long serialVersionUID = -3935653340737908064L;

    @Autowired
    private ClienteService clienteService;

    private Perfil perfil = new Perfil();

    @PostConstruct
    private void init() {
        System.out.print(PerfilUsuarioBean.class.getPackage());
    }

    public void atualizar() {
        InputText findComponent = (InputText) FacesContext.getCurrentInstance().getViewRoot().findComponent("formEdicao:inputText");
        findComponent.setValid(false);
        findComponent.setRequired(true);
        findComponent.setValue("dasdasdasd");
        RequestContext.getCurrentInstance().update("formEdicao");
        System.out.println("com.spring.principal.perfil.controller.PerfilUsuarioBean.atualizar()");
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
