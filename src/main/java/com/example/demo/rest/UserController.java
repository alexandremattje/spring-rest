package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsuarioAutenticado;
import com.example.demo.model.TokenService;
import com.example.demo.model.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TokenService tokenService;

	@GetMapping(path = "/renovar-ticket")
	public ResponseEntity<Boolean> listar(@RequestParam String token) {
		return new ResponseEntity<>(tokenService.renovarTicket(token), HttpStatus.OK);
	}

	@PostMapping(path = "/autenticar")
	public ResponseEntity<UsuarioAutenticado> autenticar(@RequestParam String usuario, @RequestParam String senha) {
		return new ResponseEntity<>(usuarioService.autenticar(usuario, senha), HttpStatus.OK);
	}

}
