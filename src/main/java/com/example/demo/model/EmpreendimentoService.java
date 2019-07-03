package com.example.demo.model;

import static com.example.demo.model.jpa.QPais.pais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.UserDetailsImpl;
import com.example.demo.dto.UsuarioAutenticado;
import com.example.demo.model.jpa.User;
import com.example.demo.model.repository.UserRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class EmpreendimentoService {

    @Autowired
    private EntityManager em;

    public List<Object> listAllFromFiltro(String filtro) {
        Query qry = this.em.createNativeQuery("select cast (row_to_json(t) as text) as unidades from empreendimentos as t");
        List<String> list = qry.getResultList();
        List<Object> result = new ArrayList<>();
        list.forEach(t -> {
            JSONParser parse = new JSONParser(t);
            try {
                result.add(parse.parse());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });
        return result;
    }

}
