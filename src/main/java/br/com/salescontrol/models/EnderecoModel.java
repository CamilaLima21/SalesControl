package br.com.salescontrol.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ENDERECOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(length = 5, name = "id_endereco")
	private Integer idEndereco;
	
	@Column(length = 80, name = "rua")
	private String rua;
	@Column(length = 5, name = "numero")
	private Integer numero;
	@Column(length = 40, name = "bairro")
	private String bairro;
	@Column(length = 40, name = "cidade")
	private String cidade;
	@Column(length = 2, name = "uf")
	private String uf;
	
	@ManyToOne
	@JoinColumn(name ="id_cliente")
	private ClienteModel cliente;
}
