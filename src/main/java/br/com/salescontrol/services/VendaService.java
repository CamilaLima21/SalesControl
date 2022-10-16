package br.com.salescontrol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salescontrol.dtos.VendaDto;
import br.com.salescontrol.models.VendaModel;
import br.com.salescontrol.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public List<VendaDto> getAll() {
		List<VendaModel> listaVenda = vendaRepository.findAll();
		List<VendaDto> listaDto = new ArrayList<>();
		
		for(VendaModel vendaModel : listaVenda) {
			listaDto.add(vendaModel.toDTO());
		}
		return listaDto;		
	}
	
	public VendaDto getOne(Integer id) {
		Optional<VendaModel> optional = vendaRepository.findById(id);
		VendaModel venda = optional.orElse(new VendaModel());
		return venda.toDTO();
	}
	
	public VendaDto save(VendaModel venda) {
		return vendaRepository.save(venda).toDTO();
	}
	
	public VendaDto update(Integer id, VendaModel vendaNova) {
		Optional<VendaModel> optional = vendaRepository.findById(id);
		 
		if(optional.isPresent() == true) {
			VendaModel vendaBD = optional.get();
			vendaBD.setCliente(vendaNova.getCliente());
			vendaBD.setProduto(vendaNova.getProduto());
			vendaBD.setFormaPgto(vendaNova.getFormaPgto());
			return vendaRepository.save(vendaBD).toDTO();
		}
		else {
			return new VendaModel().toDTO();
		}
	}

	public void delete(Integer id) {
		vendaRepository.deleteById(id);
	}
}
