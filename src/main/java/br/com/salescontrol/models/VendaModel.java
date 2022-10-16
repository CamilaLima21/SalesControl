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

@Entity
@Table(name= "TAB_VENDAS")
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
}
