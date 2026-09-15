package com.example.dito;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dito.Produto;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findByPrecoBetween(DOuble min, Double max);
}