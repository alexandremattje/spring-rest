package com.example.demo.model;

import com.example.demo.dto.PaisDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.demo.model.jpa.QPais.pais;

@Component
public class PaisModel {

    @Autowired
    private EntityManager em;

    public List<PaisDTO> listAll() {
        JPAQuery query = new JPAQuery(em);
        query.from(pais);

        return query.select(
                Projections.fields(PaisDTO.class, pais.id, pais.nome, pais.sigla, pais.gentilico)).fetch();

    }

}
