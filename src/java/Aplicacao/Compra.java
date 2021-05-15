
package Aplicacao;

import java.util.Date;


public class Compra {
    
    private int idcompra;
    private int quantidadecompra;
    private Date datacompra;
    private int valorcompra;
    private int idfornecedor;
    private int idproduto;
    private int idcomprador;

    public Compra(int idcompra, int quantidadecompra, Date datacompra, int valorcompra, int idfornecedor, int idproduto, int idcomprador) {
        this.idcompra = idcompra;
        this.quantidadecompra = quantidadecompra;
        this.datacompra = datacompra;
        this.valorcompra = valorcompra;
        this.idfornecedor = idfornecedor;
        this.idproduto = idproduto;
        this.idcomprador = idcomprador;
    }

    public Compra() {
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getQuantidadecompra() {
        return quantidadecompra;
    }

    public void setQuantidadecompra(int quantidadecompra) {
        this.quantidadecompra = quantidadecompra;
    }

    public Date getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    public int getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(int valorcompra) {
        this.valorcompra = valorcompra;
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(int idcomprador) {
        this.idcomprador = idcomprador;
    }
    
    
    
}
