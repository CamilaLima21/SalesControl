package br.com.salescontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.salescontrol.models.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer>{

}
