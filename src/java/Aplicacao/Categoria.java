
package Aplicacao;

public class Categoria {
    
    private int idcategoria;
    private String nome_categoria;

    public Categoria(int idcategoria, String nome_categoria) {
        this.idcategoria = idcategoria;
        this.nome_categoria = nome_categoria;
    }

    public Categoria() {
       
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }
    
    
    
}
