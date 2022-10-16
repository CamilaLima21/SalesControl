package br.com.salescontrol.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TAB_VENDAS")
public class VendaModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idVenda;
	
}
