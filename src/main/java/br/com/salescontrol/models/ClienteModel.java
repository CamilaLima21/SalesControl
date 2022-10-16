package br.com.salescontrol.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.salescontrol.dtos.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CLIENTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 5, name = "id_cliente")
	private Integer idCliente;

	@Column(length = 50, name = "nome_cliente")
	private String nomeCliente;

	@Column(length = 11, name = "cpf_cliente")
	private String cpfCliente;

	@Column(length = 80, name = "endereco_cliente")
	private String enderecoCliente;

	@OneToMany(mappedBy = "cliente")
	private List<EnderecoModel> endereco;

	@OneToMany(mappedBy = "cliente")
	private List<VendaModel> vendas;

	public ClienteDto toDTO() {
		ModelMapper mapper = new ModelMapper();
		ClienteDto dto = mapper.map(this, ClienteDto.class);
		return dto;
	}

}
