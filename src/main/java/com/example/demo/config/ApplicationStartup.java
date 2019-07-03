package com.example.demo.config;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.UsuarioService;
import com.example.demo.model.jpa.Pais;
import com.example.demo.model.jpa.User;

@Component
public class ApplicationStartup
implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  private EntityManager em;

  @Autowired
  private UsuarioService userService;

  @Transactional
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

//    userService.save(User.builder()
//            .senha("manager")
//            .login("convidado")
//            .nome("Usuário convidado")
//            .administrador(Boolean.FALSE)
//            .build());
//
//    userService.save(User.builder()
//            .senha("suporte")
//            .login("admin")
//            .nome("Gestor")
//            .administrador(Boolean.TRUE)
//            .build());
//
//    this.em.persist(new Pais(null, "Brasil", "BR", "Brasileiro"));
//    this.em.persist(new Pais (null, "Argentina", "AR", "Argentino"));
//    this.em.persist(new Pais (null, "Alemanha", "AL", "Alemão"));

  }

}
