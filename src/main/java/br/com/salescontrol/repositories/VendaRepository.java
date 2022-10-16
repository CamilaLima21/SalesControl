package br.com.salescontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrol.models.VendaModel;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Integer>{

}
