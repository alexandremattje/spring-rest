package com.example.demo.rest;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaisDTO;
import com.example.demo.dto.UserDetailsImpl;
import com.example.demo.dto.UsuarioAutenticado;
import com.example.demo.model.PaisModel;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private PaisModel paisModel;

    @GetMapping(path = "/renovar-ticket")
    public ResponseEntity<Collection<PaisDTO>> listar() {
        List<PaisDTO> all = this.paisModel.listAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(path = "/autenticar")
    public ResponseEntity<UsuarioAutenticado> autenticar(@RequestParam String usuario, @RequestParam String senha) {
    }

}
