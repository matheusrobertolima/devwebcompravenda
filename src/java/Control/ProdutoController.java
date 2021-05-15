package Control;

import Aplicacao.Produto;
import Aplicacao.Categoria;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ProdutoDAO;
import Model.CategoriaDAO;


@WebServlet(name = "ProdutoController", urlPatterns = {"/ProdutoController"})
public class ProdutoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProdutoDAO produtodao = new ProdutoDAO();
        CategoriaDAO categoriadao = new CategoriaDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Produto> meusProdutos;
        ArrayList<Categoria> minhasCategorias;
        String mensagem;
        String link  = "ProdutoController?acao=liberarvenda";
        

        Produto produto = new Produto();
        
        switch (acao) {
            case "mostrar":
                meusProdutos = produtodao.getLista();
                minhasCategorias = categoriadao.getLista();
                               
                request.setAttribute("meusProdutos", meusProdutos);
                request.setAttribute("minhasCategorias", minhasCategorias);
                
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/produtos.jsp");
                mostrar.forward(request, response);
                break;
                
            case "liberarvenda":
                meusProdutos = produtodao.getLista();
                
                
                
                request.setAttribute("meusProdutos", meusProdutos);
                
                RequestDispatcher liberarvenda = getServletContext().getRequestDispatcher("/liberarvenda.jsp");
                liberarvenda.forward(request, response);
                break;

                
            case "liberar":
                             

                id = Integer.parseInt(request.getParameter("id"));
                produto = produtodao.getProdutoPorID(id);
                produto.setLiberado_venda("S");
                if (produtodao.gravar(produto)) {
                mensagem = "Produto liberado para venda!";
                
            } else {
                mensagem = "Erro ao liberar produto!";
            }
           
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("link", link);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                rd.forward(request, response);
                
                    
                break;
                
            case "bloquear":
                

                id = Integer.parseInt(request.getParameter("id"));
                produto = produtodao.getProdutoPorID(id);
                produto.setLiberado_venda("N");
                if (produtodao.gravar(produto)) {
                mensagem = "Produto bloqueado para venda!";
            } else {
                mensagem = "Erro ao bloquear produto!";
            }
           
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("link", link);
                RequestDispatcher rs = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                rs.forward(request, response);
                
                break;
                
            case "relatorioestoque":
                meusProdutos = produtodao.getLista();
                    
                request.setAttribute("meusProdutos", meusProdutos);
                
                RequestDispatcher mostrarestoque = getServletContext().getRequestDispatcher("/relatorioestoque.jsp");
                mostrarestoque.forward(request, response);
                break;
                
         
        
    } 
    }
           
        
    }



