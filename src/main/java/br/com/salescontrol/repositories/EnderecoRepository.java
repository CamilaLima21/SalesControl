package br.com.salescontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrol.models.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer>{

}
