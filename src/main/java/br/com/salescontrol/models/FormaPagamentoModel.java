package br.com.salescontrol.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_FORMA_PAGAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamentoModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_forma_pgto")
	private Integer idFormaPgto;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToOne(mappedBy = "formaPgto")
	private VendaModel venda;
}
