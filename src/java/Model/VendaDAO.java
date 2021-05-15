package Model;

import Aplicacao.Venda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "VendaDAO", urlPatterns = {"/VendaDAO"})
public class VendaDAO extends HttpServlet {

  private Connection conexao;
    public VendaDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Venda> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Venda> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from vendas");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Venda para armazenar os dados
                //que vieram do BD
                Venda venda = new Venda();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                venda.setIdvenda(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "quantidade_venda" do ResultSet (rs)
                venda.setQuantidadevenda(rs.getInt("quantidade_venda"));
                //Pega o conteúdo da coluna "data_venda" do ResultSet (rs)
                venda.setDatavenda(rs.getDate("data_venda"));
                //Pega o conteúdo da coluna "valor_venda" do ResultSet (rs)
                venda.setValorvenda(rs.getFloat("valor_venda"));
                //Pega o conteúdo da coluna "id_cliente" do ResultSet (rs)
                venda.setIdcliente(rs.getInt("id_cliente"));
                //Pega o conteúdo da coluna "id_produto" do ResultSet (rs)
                venda.setIdproduto(rs.getInt("id_produto"));
                //Pega o conteúdo da coluna "id_vendedor" do ResultSet (rs)
                venda.setIdvendedor(rs.getInt("id_vendedor"));

                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(venda);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Vendas encontrados no banco de dados.
        return resultado;
    }
    
    public Venda getVendaPorID( int codigo ) {
        Venda Venda = new Venda();
        try {
            String sql = "SELECT * FROM vendas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Venda.setIdvenda(rs.getInt("id"));                             
                Venda.setQuantidadevenda(rs.getInt("quantidade_venda"));
                Venda.setDatavenda(rs.getDate("data_venda"));
                Venda.setValorvenda(rs.getFloat("valor_venda"));
                Venda.setIdcliente(rs.getInt("id_cliente"));
                Venda.setIdproduto(rs.getInt("id_produto"));
                Venda.setIdvendedor(rs.getInt("id_vendedor"));

            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Venda;
    }
    
    public boolean gravar( Venda Venda ) {
        try {
            String sql;
            
            
            if ( Venda.getIdvenda() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO vendas (quantidade_venda,data_venda,valor_venda,id_cliente,id_produto,id_vendedor) VALUES (?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE vendas SET quantidade_venda=?, data_venda=?, valor_venda=?, id_cliente=?, id_produto=?, id_vendedor=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, Venda.getQuantidadevenda());         
            ps.setDate(2, (Date) Venda.getDatavenda());
            ps.setFloat(3, Venda.getValorvenda());
            ps.setInt(4, Venda.getIdcliente());
            ps.setInt(5, Venda.getIdproduto());
            ps.setInt(6, Venda.getIdvendedor());
            
            if ( Venda.getIdvenda()> 0 )
                ps.setInt(7, Venda.getIdvenda());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int idvenda ) {
        try {
            String sql = "DELETE FROM vendas WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idvenda);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
