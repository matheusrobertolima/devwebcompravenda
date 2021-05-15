
package Model;

import Aplicacao.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "ClienteDAO", urlPatterns = {"/ClienteDAO"})
public class ClienteDAO extends HttpServlet {

  private Connection conexao;
    public ClienteDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    public ArrayList<Cliente> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Cliente> resultado = new ArrayList<>();
        try {            
            // Cria o objeto que será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from clientes");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Cliente para armazenar os dados
                //que vieram do BD
                Cliente cliente = new Cliente();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                cliente.setIdcliente(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                cliente.setNome(rs.getString("nome"));
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                cliente.setCpf(rs.getString("cpf"));
                //Pega o conteúdo da coluna "endereco" do ResultSet (rs)
                cliente.setEndereco(rs.getString("endereco"));
                //Pega o conteúdo da coluna "bairro" do ResultSet (rs)
                cliente.setBairro(rs.getString("bairro"));
                //Pega o conteúdo da coluna "cidade" do ResultSet (rs)
                cliente.setCidade(rs.getString("cidade"));
                //Pega o conteúdo da coluna "uf" do ResultSet (rs)
                cliente.setUf(rs.getString("uf"));
                //Pega o conteúdo da coluna "cep" do ResultSet (rs)
                cliente.setCep(rs.getString("cep"));
                //Pega o conteúdo da coluna "telefone" do ResultSet (rs)
                cliente.setTelefone(rs.getString("telefone"));
                //Pega o conteúdo da coluna "email" do ResultSet (rs)
                cliente.setEmail(rs.getString("email"));
                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(cliente);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Clientes encontrados no banco de dados.
        return resultado;
    }
    
    public Cliente getClientePorID( int codigo ) {
        Cliente Cliente = new Cliente();
        try {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Cliente.setIdcliente(rs.getInt("id"));                           
                Cliente.setNome(rs.getString("nome"));
                Cliente.setCpf(rs.getString("cpf"));
                Cliente.setEndereco(rs.getString("endereco"));
                Cliente.setBairro(rs.getString("bairro"));
                Cliente.setCidade(rs.getString("cidade"));
                Cliente.setUf(rs.getString("uf"));
                Cliente.setCep(rs.getString("cep"));
                Cliente.setTelefone(rs.getString("telefone"));
                Cliente.setEmail(rs.getString("email"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Cliente;
    }
    
    public boolean gravar( Cliente Cliente ) {
        try {
            String sql;
            if ( Cliente.getIdcliente() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO clientes (nome,cpf,endereco,bairro,cidade,uf,cep,telefone,email) VALUES (?,?,?,?,?,?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE clientes SET nome=?, cpf=?, endereco=?, bairro=?, cidade=?, uf=?, cep=?, telefone=?, email=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Cliente.getNome());
            ps.setString(2, Cliente.getCpf());
            ps.setString(3, Cliente.getEndereco());
            ps.setString(4, Cliente.getBairro());
            ps.setString(5, Cliente.getCidade());
            ps.setString(6, Cliente.getUf());
            ps.setString(7, Cliente.getCep());
            ps.setString(8, Cliente.getTelefone());
            ps.setString(9, Cliente.getEmail());
            
            if ( Cliente.getIdcliente()> 0 )
                ps.setInt(10, Cliente.getIdcliente());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int idcliente ) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idcliente);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
}
