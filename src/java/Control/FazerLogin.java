
package Control;

import Model.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Aplicacao.Usuario;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FazerLogin", urlPatterns = {"/FazerLogin"})
public class FazerLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // pegando os parâmetros do request
            Usuario usuario = new Usuario();
            UsuarioDAO usuariodao = new UsuarioDAO();
            
            usuario.setCpf(request.getParameter("cpf_login"));
            usuario.setSenha(request.getParameter("senha_login"));
            
            usuario = usuariodao.verificaUser(usuario);
            
            if(usuario.isIsValid()){
            
             HttpSession session = request.getSession(true);	    
            session.setAttribute("usuario",usuario); 
            response.sendRedirect("paginausuarioinicial.jsp"); //pagina logada  
            
            }

            else{
            
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response); 
            
            }
            
            } finally {
            out.close();
        } 
            
    
    }

}
