package Model;

import Aplicacao.Compra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "CompraDAO", urlPatterns = {"/CompraDAO"})
public class CompraDAO extends HttpServlet {

  private Connection conexao;
    public CompraDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Compra> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Compra> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from compras");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Compra para armazenar os dados
                //que vieram do BD
                Compra compra = new Compra();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                compra.setIdcompra(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "quantidade_compra" do ResultSet (rs)
                compra.setQuantidadecompra(rs.getInt("quantidade_compra"));
                //Pega o conteúdo da coluna "data_compra" do ResultSet (rs)
                compra.setDatacompra(rs.getDate("data_compra"));
                //Pega o conteúdo da coluna "valor_compra" do ResultSet (rs)
                compra.setValorcompra(rs.getInt("valor_compra"));
                //Pega o conteúdo da coluna "id_fornecedor" do ResultSet (rs)
                compra.setIdfornecedor(rs.getInt("id_fornecedor"));
                //Pega o conteúdo da coluna "id_produto" do ResultSet (rs)
                compra.setIdproduto(rs.getInt("id_produto"));
                //Pega o conteúdo da coluna "id_comprador" do ResultSet (rs)
                compra.setIdcomprador(rs.getInt("id_comprador"));

                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(compra);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Compras encontrados no banco de dados.
        return resultado;
    }
    
    public Compra getCompraPorID( int codigo ) {
        Compra Compra = new Compra();
        try {
            String sql = "SELECT * FROM compras WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Compra.setIdcompra(rs.getInt("id"));                              
                Compra.setQuantidadecompra(rs.getInt("quantidade_compra"));
                Compra.setDatacompra(rs.getDate("data_compra"));
                Compra.setValorcompra(rs.getInt("valor_compra"));
                Compra.setIdfornecedor(rs.getInt("id_fornecedor"));
                Compra.setIdproduto(rs.getInt("id_produto"));
                Compra.setIdcomprador(rs.getInt("id_comprador"));

            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Compra;
    }
    
    public boolean gravar( Compra Compra ) {
        try {
            String sql;  
                  
            
            if ( Compra.getIdcompra() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO compras (quantidade_compra,data_compra,valor_compra,id_fornecedor,id_produto,id_comprador) VALUES (?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE compras SET quantidade_compra=?, data_compra=?, valor_compra=?, id_fornecedor=?, id_produto=?, id_comprador=? WHERE id=?";
                
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, Compra.getQuantidadecompra());         
            ps.setDate(2, (Date) Compra.getDatacompra());
            ps.setFloat(3, Compra.getValorcompra());
            ps.setInt(4, Compra.getIdfornecedor());
            ps.setInt(5, Compra.getIdproduto());
            ps.setInt(6, Compra.getIdcomprador());
            
            if ( Compra.getIdcompra() > 0 )
                ps.setInt(7, Compra.getIdcompra());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int idcompra ) {
        try {
            String sql = "DELETE FROM compras WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idcompra);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
