package br.com.salescontrol.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("{id}")
	public ResponseEntity<ClienteDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<ClienteDto> save(@Valid @RequestBody ClienteDto cliente) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente.toEntity()));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<ClienteDto> update(@PathVariable Integer id, @RequestBody ClienteDto cliente) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, cliente.toEntity()));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		clienteService.delete(id);
	}
}
