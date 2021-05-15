package Control;

import Aplicacao.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.UsuarioDAO;

@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Usuario> meusUsuarios;
        String mensagem;
        String link  = "paginausuarioinicial.jsp";
        String tipo;

        Usuario usuario = new Usuario();
        
        
        switch (acao) {
            case "mostraradministrador":
                tipo = "administrador";
                meusUsuarios = usuariodao.getListaAdministrador();
                request.setAttribute("meusUsuarios", meusUsuarios);
                request.setAttribute("tipo", tipo);
                RequestDispatcher mostraradministrador = getServletContext().getRequestDispatcher("/listausuario.jsp");
                mostraradministrador.forward(request, response);
                break;
                
            case "mostrarvendedor":
                tipo = "vendedor";
                meusUsuarios = usuariodao.getListaVendedor();
                request.setAttribute("meusUsuarios", meusUsuarios);
                request.setAttribute("tipo", tipo);
                RequestDispatcher mostrarvendedor = getServletContext().getRequestDispatcher("/listausuario.jsp");
                mostrarvendedor.forward(request, response);
                break;
                
            case "mostrarcomprador":
                tipo = "comprador";
                meusUsuarios = usuariodao.getListaComprador();
                request.setAttribute("meusUsuarios", meusUsuarios);
                request.setAttribute("tipo", tipo);
                RequestDispatcher mostrarcomprador = getServletContext().getRequestDispatcher("/listausuario.jsp");
                mostrarcomprador.forward(request, response);
                break;

            case "incluiradministrador":
                usuario.setIdusuario(0);                           
                usuario.setNome("");
                usuario.setCpf("");
                usuario.setSenha("");
                usuario.setTipo("0");


                request.setAttribute("usuario", usuario);
                RequestDispatcher incluiradm = getServletContext().getRequestDispatcher("/formusuario.jsp"); 
                incluiradm.forward(request, response);
                break;
                
            case "incluirvendedor":
                usuario.setIdusuario(0);                           
                usuario.setNome("");
                usuario.setCpf("");
                usuario.setSenha("");
                usuario.setTipo("1");


                request.setAttribute("usuario", usuario);
                RequestDispatcher incluirvendedor = getServletContext().getRequestDispatcher("/formusuario.jsp"); 
                incluirvendedor.forward(request, response);
                break;
                
            case "incluircomprador":
                usuario.setIdusuario(0);                           
                usuario.setNome("");
                usuario.setCpf("");
                usuario.setSenha("");
                usuario.setTipo("2");


                request.setAttribute("usuario", usuario);
                RequestDispatcher incluircomprador = getServletContext().getRequestDispatcher("/formusuario.jsp"); 
                incluircomprador.forward(request, response);
                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                usuario = usuariodao.getUsuarioPorID(id);

                if (usuario.getIdusuario() > 0) {
                    request.setAttribute("usuario", usuario);
                    RequestDispatcher rs = request.getRequestDispatcher("formusuario.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar usuario!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;

            case "excluir":
                
                
                id = Integer.parseInt(request.getParameter("id"));
                usuariodao.excluir(id);
                
                mensagem = "Usuario excluído com sucesso!";
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("link", link);
                
                RequestDispatcher aposexcluiradministrador = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                aposexcluiradministrador.forward(request, response);
                break;
         
        } 
        
        
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "paginausuarioinicial.jsp";
        try {
            Usuario usuario = new Usuario();

            usuario.setIdusuario(Integer.parseInt(request.getParameter("id")));
            usuario.setNome(request.getParameter("nome"));
            usuario.setCpf(request.getParameter("cpf"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setTipo(request.getParameter("tipo"));
            
            UsuarioDAO usuariodao = new UsuarioDAO();

            if (usuariodao.gravar(usuario)) {
                mensagem = "Usuario gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuario!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar usuario!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
        
    }



}
