package com.example.demo.model;

import static com.example.demo.model.jpa.QToken.token1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.jpa.Token;
import com.example.demo.model.repository.TokenRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;

@Service
public class TokenService {

	@Autowired
	private TokenRepository repository;

	@Autowired
	private EntityManager em;

	@Transactional
	public String autenticar(String login, Boolean administrador) {
		Token jpa = new Token();
		jpa.setAdministrador(administrador);
		jpa.setLogin(login);
		jpa.setToken(UUID.randomUUID().toString());
		jpa.setExpiracao(createDataExpiracao());
		repository.save(jpa);

		return jpa.getToken();
	}

	private Date createDataExpiracao() {
		return Date.from(LocalDateTime.now()
				.plus(5, ChronoUnit.MINUTES)
				.atZone(ZoneId.systemDefault())
				.toInstant());
	}

	@Transactional
	public Boolean renovarTicket(String token) {
		if (tokenValido(token)) {
			JPAUpdateClause update = new JPAUpdateClause(em, token1);
			update.set(token1.expiracao, createDataExpiracao());
			update.where(token1.token.eq(token));
			update.execute();
			return true;
		}

		return false;
	}

	/**
	 * @param token
	 * @return
	 */
	public boolean tokenValido(String token) {
		JPAQuery qry = new JPAQuery(em);
		qry.from(token1);
		qry.where(token1.token.eq(token));
		qry.select(token1.expiracao);
		Date expiracao = (Date) qry.fetchOne();
		if (expiracao == null) {
			return Boolean.FALSE;
		}

		return expiracao
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDateTime()
				.isAfter(LocalDateTime.now());
	}
}
