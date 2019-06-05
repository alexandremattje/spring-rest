package com.example.demo.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TOKEN")
public class Token {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "SEQ_TOKEN")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TOKEN")
	private Long id;

	@Column(name = "token")
	private String token;

	@Column(name = "login")
	private String login;

	@Column(name = "expiracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiracao;

	@Column(name = "administrador")
	private Boolean administrador;
}
