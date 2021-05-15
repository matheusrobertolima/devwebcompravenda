
package Aplicacao;

import java.util.Date;


public class Venda {
    
    private int idvenda;
    private int quantidadevenda;
    private Date datavenda;
    private float valorvenda;
    private Cliente cliente;
    private Produto produto;
    private Usuario usuario;
    private int idcliente;
    private int idproduto;
    private int idvendedor;

    public Venda(int idvenda, int quantidadevenda, Date datavenda, float valorvenda, int idcliente, int idproduto, int idvendedor) {
        this.idvenda = idvenda;
        this.quantidadevenda = quantidadevenda;
        this.datavenda = datavenda;
        this.valorvenda = valorvenda;
        idcliente = cliente.getIdcliente();
        idproduto = produto.getIdproduto();
        idvendedor = usuario.getIdusuario();
    }

    public Venda() {
        
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public int getQuantidadevenda() {
        return quantidadevenda;
    }

    public void setQuantidadevenda(int quantidadevenda) {
        this.quantidadevenda = quantidadevenda;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public float getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(float valorvenda) {
        this.valorvenda = valorvenda;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }
    
    
    
    
    
    
}
