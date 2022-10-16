package br.com.salescontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrol.models.FormaPagamentoModel;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoModel, Integer>{

}
