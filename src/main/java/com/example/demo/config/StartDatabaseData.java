package com.example.demo.config;

import com.example.demo.model.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
@Scope(value = "prototype")
public class StartDatabaseData implements WebApplicationInitializer {

    @Autowired
    private EntityManager em;

    @Autowired
    private UsuarioModel userService;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

//        userService.save(User.builder()
//                .password("manager")
//                .username("convidado")
//                .build());
//        insert into usuario(id,login,senha,nome,administrador) values
//                (SEQ_USUARIO.NEXTVAL, "convidado", "manager", "Usuário convidado",
//                        0);
//        insert into usuario(id,login,senha,nome,administrador) values
//                (SEQ_USUARIO.NEXTVAL, "admin", "suporte", "Gestor", 1);
//        insert into pais(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL,
//                "Brasil", "BR", "Brasileiro");
//        insert into pais(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL,
//                "Argentina", "AR", "Argentino");
//        insert into pais(id,nome,sigla,gentilico) values (SEQ_PAIS.NEXTVAL,
//                "Alemanha", "AL", "Alemão");

//        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));
//        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));
//        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));

    }
}
