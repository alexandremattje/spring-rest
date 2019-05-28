package com.example.demo.rest;

import com.example.demo.dto.PaisDTO;
import com.example.demo.model.PaisModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisModel paisModel;

    @GetMapping(path = "/listar")
    public ResponseEntity<Collection<PaisDTO>> listar() {
//        if (!this.service.hasAccess(filter.getId(), this.api.getPrincipal().getCollaboratorId())) {
//            throw new AccessDeniedException();
//        }

        List<PaisDTO> all = this.paisModel.listAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(path = "/fromjson")
    public ResponseEntity<List<String>> fromJson() {
        List<String> all = this.paisModel.listFromJson();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }


}
