package br.com.salescontrol.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salescontrol.dtos.ClienteDto;
import br.com.salescontrol.models.ClienteModel;
import br.com.salescontrol.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDto> getAll() {
		List<ClienteModel> listaCliente =  clienteRepository.findAll();
		List<ClienteDto> listaDto = new ArrayList<>();
		
		for(ClienteModel clienteModel : listaCliente) {
			listaDto.add(clienteModel.toDTO());
		}
		return listaDto;
	}
}
