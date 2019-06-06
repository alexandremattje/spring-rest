package com.example.demo.model;

import static com.example.demo.model.jpa.QPais.pais;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.PaisDTO;
import com.example.demo.model.jpa.Pais;
import com.example.demo.model.repository.PaisRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

@Component
public class PaisService {

	@Autowired
	private EntityManager em;

	@Autowired
	private PaisRepository repository;

	public List<PaisDTO> listAll() {
		JPAQuery query = new JPAQuery(em);
		query.from(pais);

		return new ArrayList<>(query.select(
				Projections.fields(PaisDTO.class, pais.id, pais.nome, pais.sigla, pais.gentilico)).fetch());
	}

	@Transactional
	public PaisDTO salvar(PaisDTO dto) {
		if (dto.getId() == null) {
			Pais jpa = new Pais();
			jpa.setGentilico(dto.getGentilico());
			jpa.setNome(dto.getNome());
			jpa.setSigla(dto.getSigla());
			jpa = repository.save(jpa);
			dto.setId(jpa.getId());
		} else {
			JPAUpdateClause update = new JPAUpdateClause(em, pais);
			update.set(pais.gentilico, dto.getGentilico());
			update.set(pais.nome, dto.getNome());
			update.set(pais.sigla, dto.getSigla());
			update.where(pais.id.eq(dto.getId()));
			update.execute();
		}

		return dto;
	}

	@Transactional
	public boolean excluir (Long id) {
		JPADeleteClause delete = new JPADeleteClause(em, pais);
		delete.where(pais.id.eq(id));
		return delete.execute() > 0;
	}

	public List<PaisDTO> listAllFromFiltro(String filtro) {
		JPAQuery query = new JPAQuery(em);
		query.where(pais.nome.likeIgnoreCase("%" + filtro + "%"));
		query.from(pais);

		return new ArrayList<>(query.select(
				Projections.fields(PaisDTO.class, pais.id, pais.nome, pais.sigla, pais.gentilico)).fetch());
	}
}
