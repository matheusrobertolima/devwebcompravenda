package Model;

import Aplicacao.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ProdutoDAO", urlPatterns = {"/ProdutoDAO"})
public class ProdutoDAO extends HttpServlet {

        private Connection conexao;
    public ProdutoDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<Produto> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Produto> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from produtos");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Produto para armazenar os dados
                //que vieram do BD
                Produto produto = new Produto();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                produto.setIdproduto(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "produto" do ResultSet (rs)
                produto.setNome_produto(rs.getString("nome_produto"));
                //Pega o conteúdo da coluna "descricao" do ResultSet (rs)
                produto.setDescricao(rs.getString("descricao"));
                //Pega o conteúdo da coluna "preco_compra" do ResultSet (rs)
                produto.setPreco_compra(rs.getDouble("preco_compra"));
                //Pega o conteúdo da coluna "preco_venda" do ResultSet (rs)
                produto.setPreco_venda(rs.getDouble("preco_venda"));
                //Pega o conteúdo da coluna "quantidade_disponivel" do ResultSet (rs)
                produto.setQuantidade_disponivel(rs.getInt("quantidade_disponível"));
                //Pega o conteúdo da coluna "liberado_venda" do ResultSet (rs)
                produto.setLiberado_venda(rs.getString("liberado_venda"));
                //Pega o conteúdo da coluna "id_categoria" do ResultSet (rs)
               produto.setId_categoria(rs.getInt("id_categoria"));

                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(produto);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Produtos encontrados no banco de dados.
        return resultado;
    }
 
    public Produto getProdutoPorID( int codigo ) {
        Produto Produto = new Produto();
        try {
            String sql = "SELECT * FROM produtos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Produto.setIdproduto(rs.getInt("id"));                           
                Produto.setNome_produto(rs.getString("nome_produto"));
                Produto.setDescricao(rs.getString("descricao"));
                Produto.setPreco_compra(rs.getDouble("preco_compra"));
                Produto.setPreco_venda(rs.getDouble("preco_venda"));
                Produto.setQuantidade_disponivel(rs.getInt("quantidade_disponível"));
                Produto.setLiberado_venda(rs.getString("liberado_venda"));
                Produto.setId_categoria(rs.getInt("id_categoria"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Produto;
    }
    
    public boolean gravar( Produto Produto ) {
        try {
            String sql;
            if ( Produto.getIdproduto() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO produtos (nome_produto,descricao,preco_compra,preco_venda,quantidade_disponível,liberado_venda,id_categoria) VALUES (?,?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE produtos SET nome_produto=?, descricao=?, preco_compra=?, preco_venda=?, quantidade_disponível=?, liberado_venda=?, id_categoria=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Produto.getNome_produto());
            ps.setString(2, Produto.getDescricao());
            ps.setDouble(3, Produto.getPreco_compra());
            ps.setDouble(4, Produto.getPreco_venda());
            ps.setInt(5, Produto.getQuantidade_disponivel());
            ps.setString(6, Produto.getLiberado_venda());
            ps.setInt(7, Produto.getId_categoria());

            
            if ( Produto.getIdproduto() > 0 )
                ps.setInt(8, Produto.getIdproduto());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int idproduto ) {
        try {
            String sql = "DELETE FROM produtos WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idproduto);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    }


    
