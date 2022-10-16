package br.com.salescontrol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public ClienteDto getOne(Integer id) {
		Optional<ClienteModel> optional = clienteRepository.findById(id);
		ClienteModel cliente = optional.orElse(new ClienteModel());
		return cliente.toDTO();
	}
	
	public ClienteDto save(ClienteModel cliente) {
		return clienteRepository.save(cliente).toDTO();
	}
	
	public ClienteDto update(Integer id, ClienteModel clienteNovo) {
		Optional<ClienteModel> optional = clienteRepository.findById(id);
		
		if(optional.isPresent() == true) {
			 ClienteModel clienteBD = optional.get();
			 clienteBD.setNomeCliente(clienteNovo.getNomeCliente());
			 clienteBD.setCpfCliente(clienteNovo.getCpfCliente());
			 clienteBD.setEnderecoCliente(clienteNovo.getEnderecoCliente());
			 return clienteRepository.save(clienteBD).toDTO();
		}
		else {
			return new ClienteModel().toDTO();
		}
	}

	public void delete(Integer id) {
		clienteRepository.deleteById(id);
		
	}
	
}
