package com.example.dito;

import com.example.dito.DTO.ProdutoDTO;
import com.example.dito.Produto;
import com.example.dito.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService{

    @Autowiredprivate ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarTodos(){
        return produtoRepository.findAll() List<Produto>
            .stream() Stream<Produto>
            .map((Produto p) -> new ProdutoDTO(p.getId(), p.getNome(), p.getPreco())) Stream<ProdutoDTO>
            .collect(Collectors.toList());
    }
    public ProdutoDTO adicionarProduto(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
    }
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto){
        Produto produto = produtoRepository,findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
    }
    public void deletarProduto(Long id){
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }
    public List<ProdutoDTO> buscarPorNome(String nome){
        return produtoRepository.findByNomeContaining(nome) List<Produto>
            .stream() Stream<Produto>
            .map(Produto p-> new ProdutoDTO(p.getId(), p.getNome(), p.getPreco())) Stream<ProdutoDTO>
            .collect(Collectors.toList());
    }
}