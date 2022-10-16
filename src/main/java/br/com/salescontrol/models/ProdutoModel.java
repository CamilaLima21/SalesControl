package br.com.salescontrol.models;

import java.math.BigDecimal;

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
@Table(name = "TB_PRODUTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 5, name = "id_produto")
	private Integer idProduto;
	
	@Column(length = 5, name = "descricao")
	private String descricao;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "id_venda")
	private VendaModel venda;
}
