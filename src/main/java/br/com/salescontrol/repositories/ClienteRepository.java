package br.com.salescontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrol.models.ClienteModel;

@Repository
public interface ClienteRepository  extends JpaRepository<ClienteModel, Integer>{

}
