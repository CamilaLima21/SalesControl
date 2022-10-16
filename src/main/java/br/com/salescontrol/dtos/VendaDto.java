package br.com.salescontrol.dtos;

import org.modelmapper.ModelMapper;

import br.com.salescontrol.models.VendaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDto {

	private Integer idVenda;
	private Integer idProduto;
	private Integer idCliente;
	private Integer idFormaPgto;
	
	public VendaModel toEntity() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, VendaModel.class);
	}
}
