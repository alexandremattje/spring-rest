package com.example.demo.model.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_PAIS")
public class Pais {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "SEQ_PAIS")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PAIS")
    private Long id;

    private String nome;

    private String sigla;

    private String gentilico;

}
