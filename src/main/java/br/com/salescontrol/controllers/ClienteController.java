package br.com.salescontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.salescontrol.dtos.ClienteDto;
import br.com.salescontrol.services.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("")
	public ResponseEntity<List<ClienteDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAll());
	}
	
	
}
