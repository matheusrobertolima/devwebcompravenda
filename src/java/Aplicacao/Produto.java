
package Aplicacao;

public class Produto {
    
    private int idproduto;
    private String nome_produto;
    private String descricao;
    private double preco_compra;
    private double preco_venda;
    private int quantidade_disponivel;
    private String liberado_venda;
    private Categoria categoria;
    private int id_categoria;

    public Produto(int idproduto, String nome_produto, String descricao, double preco_compra, double preco_venda, int quantidade_disponivel, String liberado_venda, int id_categoria) {
        this.idproduto = idproduto;
        this.nome_produto = nome_produto;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade_disponivel = quantidade_disponivel;
        this.liberado_venda = liberado_venda;
        id_categoria = categoria.getIdcategoria();
    }

    public Produto() {
    }
    
    

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade_disponivel() {
        return quantidade_disponivel;
    }

    public void setQuantidade_disponivel(int quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public String getLiberado_venda() {
        return liberado_venda;
    }

    public void setLiberado_venda(String liberado_venda) {
        this.liberado_venda = liberado_venda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
}
