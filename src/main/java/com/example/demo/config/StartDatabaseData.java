package com.example.demo.config;

import com.example.demo.model.jpa.Pais;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.logging.Logger;

import static com.example.demo.model.jpa.QPais.pais;

@Component
@Scope(value = "prototype")
public class StartDatabaseData implements WebApplicationInitializer {


    @Autowired
    private EntityManager em;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

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

        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));
        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));
        this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));

    }
}