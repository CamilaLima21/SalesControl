package br.com.salescontrol.dtos;

import org.modelmapper.ModelMapper;

import br.com.salescontrol.models.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

	private Integer idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String enderecoCliente;
	
	public ClienteModel toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, ClienteModel.class);
	}
	
}
