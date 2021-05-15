package Model;


import Aplicacao.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


@WebServlet(name = "UsuarioDAO", urlPatterns = {"/UsuarioDAO"})
public class UsuarioDAO extends HttpServlet {

        private Connection conexao;
    public UsuarioDAO() {
        try {
            // Cria a conexão com o banco de dados
            conexao = Conexao.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }
    
    public ArrayList<Usuario> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from usuarios");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Usuario para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setIdusuario(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome(rs.getString("nome"));
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setCpf(rs.getString("cpf"));                           
                //Pega o conteúdo da coluna "senha" do ResultSet (rs)
                usuario.setSenha(rs.getString("senha"));
                //Pega o conteúdo da coluna "tipo" do ResultSet (rs)
                usuario.setTipo(rs.getString("tipo"));                           

                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Usuarios encontrados no banco de dados.
        return resultado;
    }
    
    public ArrayList<Usuario> getListaAdministrador() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE tipo = 0");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Usuario para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setIdusuario(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome(rs.getString("nome"));
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setCpf(rs.getString("cpf"));                           
                //Pega o conteúdo da coluna "senha" do ResultSet (rs)
                usuario.setSenha(rs.getString("senha"));
                //Pega o conteúdo da coluna "tipo" do ResultSet (rs)
                usuario.setTipo(rs.getString("tipo"));                           

                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Usuarios encontrados no banco de dados.
        return resultado;
    }
    
    public ArrayList<Usuario> getListaVendedor() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE tipo = 1");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Usuario para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setIdusuario(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome(rs.getString("nome"));
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setCpf(rs.getString("cpf"));                           
                //Pega o conteúdo da coluna "senha" do ResultSet (rs)
                usuario.setSenha(rs.getString("senha"));
                //Pega o conteúdo da coluna "tipo" do ResultSet (rs)
                usuario.setTipo(rs.getString("tipo"));                           

                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Usuarios encontrados no banco de dados.
        return resultado;
    }
    
    public ArrayList<Usuario> getListaComprador() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Usuario> resultado = new ArrayList<>();
        try {            
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE tipo = 2");
            // rs.next() Aponta para o próximo registro do BD, se houver um 
            while( rs.next() ) {
                //Cria o objeto da classe Usuario para armazenar os dados
                //que vieram do BD
                Usuario usuario = new Usuario();
                
                //Pega o conteúdo da coluna "id" do ResultSet (rs)
                usuario.setIdusuario(rs.getInt("id"));                           
                //Pega o conteúdo da coluna "nome" do ResultSet (rs)
                usuario.setNome(rs.getString("nome"));
                //Pega o conteúdo da coluna "cpf" do ResultSet (rs)
                usuario.setCpf(rs.getString("cpf"));                           
                //Pega o conteúdo da coluna "senha" do ResultSet (rs)
                usuario.setSenha(rs.getString("senha"));
                //Pega o conteúdo da coluna "tipo" do ResultSet (rs)
                usuario.setTipo(rs.getString("tipo"));                           

                
                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(usuario);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        // Retorna a lista de Usuarios encontrados no banco de dados.
        return resultado;
    }
    
    public Usuario verificaUser(Usuario usuario) {
        String cpf = usuario.getCpf();
        String senha = usuario.getSenha();
        try {
            String sql = "SELECT * from usuarios where cpf='"+cpf+"' AND senha='"+senha+"'";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            boolean more = rs.next();
            
           if(!more) {
           
           usuario.setIsValid(false);
               
           }
           
           else if(more){
           
           int idusuario = rs.getInt("id");
           String nomeusuario = rs.getString("nome");
           String cpfusuario = rs.getString("cpf");
           String senhausuario = rs.getString("senha");
           String tipousuario = rs.getString("tipo");
           
           usuario.setIdusuario(idusuario);
           usuario.setNome(nomeusuario);
           usuario.setCpf(cpfusuario);
           usuario.setSenha(senhausuario);
           usuario.setTipo(tipousuario);
           usuario.setIsValid(true);
               
           }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        
        return usuario;
        
    }
    
    public Usuario getUsuarioPorID( int usuario ) {
        Usuario Usuario = new Usuario();
        try {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, usuario);
            
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                Usuario.setIdusuario(rs.getInt("id"));                           
                Usuario.setNome(rs.getString("nome"));
                Usuario.setCpf(rs.getString("cpf"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setTipo(rs.getString("tipo"));
            }
            
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return Usuario;
    }
    
    public boolean gravar( Usuario Usuario ) {
        try {
            String sql;
            if ( Usuario.getIdusuario() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO usuarios (nome,cpf,senha,tipo) VALUES (?,?,?,?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE usuarios SET nome=?, cpf=?, senha=?, tipo=? WHERE id=?";
            }
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, Usuario.getNome());
            ps.setString(2, Usuario.getCpf());
            ps.setString(3, Usuario.getSenha());
            ps.setString(4, Usuario.getTipo());

            
            if ( Usuario.getIdusuario() > 0 )
                ps.setInt(5, Usuario.getIdusuario());
            
            ps.execute();
            
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir( int idusuario ) {
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idusuario);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }
   
 
    }

