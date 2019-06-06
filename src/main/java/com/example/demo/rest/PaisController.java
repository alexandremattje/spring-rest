package com.example.demo.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaisDTO;
import com.example.demo.model.PaisService;
import com.example.demo.model.TokenService;


@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private PaisService paisModel;

    @Autowired
    private TokenService tokenService;

    @GetMapping(path = "/listar")
    public ResponseEntity<Collection<PaisDTO>> listar(@RequestParam String token) {
        if (tokenService.tokenValido(token)) {
            List<PaisDTO> paises = this.paisModel.listAll();
            return new ResponseEntity<>(paises, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(path = "/pesquisar")
    public ResponseEntity<Collection<PaisDTO>> pesquisar(@RequestParam String token, @RequestParam String filtro) {
        if (tokenService.tokenValido(token)) {
            List<PaisDTO> paises = this.paisModel.listAllFromFiltro(filtro);
            return new ResponseEntity<>(paises, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping(path = "/excluir")
    public ResponseEntity<Boolean> excluir(@RequestParam String token, @RequestParam Long id) {
        if (tokenService.tokenValido(token)) {
            return new ResponseEntity<>(this.paisModel.excluir(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(Boolean.FALSE, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<PaisDTO> salvar(@RequestParam String token, @RequestBody PaisDTO paisDTO) {
        if (tokenService.tokenValido(token)) {
            paisDTO = paisModel.salvar(paisDTO);
            return new ResponseEntity<>(paisDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(paisDTO, HttpStatus.UNAUTHORIZED);
    }

}
