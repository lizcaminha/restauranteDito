package com.example.dito;

@Entity
public class Produto{
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private Double preco;

    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public Double getPreco(){
        return preco;
    }
    public void setID(Long id){
        this.id=id;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setPreco(Double preco){
        this.preco=preco;
    }
}
