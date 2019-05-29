package com.example.demo.model;

import static com.example.demo.model.jpa.QPais.pais;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.PaisDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

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

	public List<String> listFromJson() {
		Query qry = this.em.createNativeQuery("select array_to_json(array_agg(row_to_json(t))) as empreendimentos " +
				"                from " +
				"            (select * from empreendimentos) as t");
		List res = qry.getResultList();
		for (Object s : res) {
			System.out.println(s);
		}
		return res;
	}

}
