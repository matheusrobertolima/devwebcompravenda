
package Control;

import Aplicacao.Categoria;
import Model.CategoriaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriaDAO categoriadao = new CategoriaDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Categoria> minhasCategorias;
        String mensagem;
        String link  = "CategoriaController?acao=mostrar";

        Categoria categoria = new Categoria();
        
        switch (acao) {
            case "mostrar":
                minhasCategorias = categoriadao.getLista();
                request.setAttribute("minhasCategorias", minhasCategorias);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/listacategoria.jsp");
                mostrar.forward(request, response);
                break;

            case "incluir":
                categoria.setIdcategoria(0);                           
                categoria.setNome_categoria("");

                request.setAttribute("categoria", categoria);
                RequestDispatcher incluir = getServletContext().getRequestDispatcher("/formcategoria.jsp"); 
                incluir.forward(request, response);
                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriadao.getCategoriaPorID(id);

                if (categoria.getIdcategoria() > 0) {
                    request.setAttribute("categoria", categoria);
                    RequestDispatcher rs = request.getRequestDispatcher("formcategoria.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar categoria!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;

            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));
                categoriadao.excluir(id);

                minhasCategorias = categoriadao.getLista();
                request.setAttribute("minhasCategorias", minhasCategorias);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/listacategoria.jsp"); 
                aposexcluir.forward(request, response);
                break;
        } 
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "CategoriaController?acao=mostrar";
        try {
            Categoria categoria = new Categoria();

            categoria.setIdcategoria(Integer.parseInt(request.getParameter("id")));
            categoria.setNome_categoria(request.getParameter("nome_categoria"));


            CategoriaDAO categoriadao = new CategoriaDAO();

            if (categoriadao.gravar(categoria)) {
                mensagem = "Categoria gravada com sucesso!";
            } else {
                mensagem = "Erro ao gravar categoria!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar categoria!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
        
    }

}
