package br.com.salescontrol.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.salescontrol.dtos.VendaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "TAB_VENDAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(length = 5, name= "id_venda")
	private Integer idVenda;
	
	@OneToMany(mappedBy = "venda")
	private List<ProdutoModel> produto;
	
	@OneToOne
	@JoinColumn(name = "id_forma_pgto")
	private FormaPagamentoModel formaPgto;
	
	@ManyToOne
	@JoinColumn(name= "id_cliente")
	private ClienteModel cliente;

	public VendaDto toDTO() {
		ModelMapper mapper = new ModelMapper();
		VendaDto dto = mapper.map(this, VendaDto.class);
		return dto;
	}
}
