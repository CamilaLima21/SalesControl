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

import br.com.salescontrol.dtos.VendaDto;
import br.com.salescontrol.services.VendaService;

@RestController
@RequestMapping("venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@GetMapping("")
	public ResponseEntity<List<VendaDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<VendaDto> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.getOne(id));
	}
	
	@PostMapping("")
	public ResponseEntity<VendaDto> save(@Valid @RequestBody VendaDto venda) {
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.save(venda.toEntity()));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<VendaDto> update(@PathVariable Integer id, @RequestBody VendaDto venda) {
		return ResponseEntity.status(HttpStatus.OK).body(vendaService.update(id, venda.toEntity()));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		vendaService.delete(id);
	}
}
