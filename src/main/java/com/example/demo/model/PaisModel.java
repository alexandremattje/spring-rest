package com.example.demo.model;

import com.example.demo.dto.PaisDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    public List<String> listFromJson() {
        Query qry = this.em.createNativeQuery("select array_to_json(array_agg(row_to_json(t))) as unidades " +
                "                'from " +
                "            '(select pounp.id as id_nome_planta, pounp.descricao, pou.id_empreendimento, " +
                "            \n" +
                "            '(select array_to_json(array_agg(row_to_json(arq))) " +
                "                        'from ( " +
                "                            'select poua.* from po_unidades poua " +
                "                            'where poua.id_empreendimento = pou.id_empreendimento) arq " +
                "                            ') as arquivos " +
                "            'from po_unidades pou " +
                "            'left join po_unidades_nome_planta pounp " +
                "            'on pounp.id = pou.id_nome_planta " +
                "            'where pou.id_empreendimento = \\'' + id + '\\'" +
                "            'group by pounp.id, pounp.descricao, pou.id_empreendimento " +
                "            'order by pounp.descricao) as t ");
        List res = qry.getResultList();
        for(Object s : res) {
            System.out.println(s);
        }
        return res;
    }

}
