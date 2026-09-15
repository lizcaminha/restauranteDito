package com.example.dito;

import com.example.dito.DTO.ProdutoDTO;
import com.example.dito.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.list;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController{
    private final ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarTodos(){
        return produtoService.listarTodos();
    }

    @PostMapping
    public ProdutoDTO adicionarProduto(@RequestBody ProdutoDTO dto){
        return produtoService.adicionarProduto(dto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        return produtoService.atualizarProduto(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }
    @GetMApping("/precos")
    public List<ProdutoDTO> buscarEntrePrecos(@RequestParam Double min, @RequestParam Double max){
        return produtoService.buscarProdutosEntrePrecos(min, max);
    }
}