package com.example.demo.config;

import com.example.demo.model.MyUserDetailsService;
import com.example.demo.model.jpa.Pais;
import com.example.demo.model.jpa.User;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class ApplicationStartup
implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  private EntityManager em;

  @Autowired
  private MyUserDetailsService userService;

  @Transactional
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {

    userService.save(User.builder()
            .password("manager")
            .username("convidado")
            .build());

    this.em.persist(new Pais(null, "Brasil", "BR", "Brasileiro"));
    this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));
    this.em.persist(new Pais (null, "Brasil", "BR", "Brasileiro"));

  }

}
