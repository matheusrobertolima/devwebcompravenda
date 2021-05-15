
package Control;

import Aplicacao.Compra;
import Aplicacao.Produto;
import Aplicacao.Fornecedor;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.CompraDAO;
import Model.ProdutoDAO;
import Model.FornecedorDAO;


@WebServlet(name = "CompraController", urlPatterns = {"/CompraController"})
public class CompraController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CompraDAO compradao = new CompraDAO();
        ProdutoDAO produtodao = new ProdutoDAO();
        FornecedorDAO fornecedordao = new FornecedorDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Compra> minhasCompras;
        ArrayList<Fornecedor> meusFornecedores;
        Produto produto = new Produto();
        Compra compra = new Compra();
        String mensagem;
        String link = "paginausuarioinicial.jsp";
        
       
        
        switch(acao) {
            case "mostrar":
                minhasCompras = compradao.getLista();
                    request.setAttribute("minhasCompras", minhasCompras);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/listacompra.jsp");
                mostrar.forward(request, response);
                break;
                
            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                compra = compradao.getCompraPorID(id);

                if (compra.getIdcompra() > 0) {
                    request.setAttribute("compra", compra);
                    RequestDispatcher rs = request.getRequestDispatcher("formcompraupdate.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar compra!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;
                
            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));               
                compradao.excluir(id);

                minhasCompras = compradao.getLista();
                request.setAttribute("minhasCompras", minhasCompras);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/listacompra.jsp"); 
                aposexcluir.forward(request, response);
                break;
                
            case "comprarproduto":
                
                id = Integer.parseInt(request.getParameter("id"));
                produto = produtodao.getProdutoPorID(id);
                meusFornecedores = fornecedordao.getLista();
                
                if(produto.getIdproduto() > 0) {
                    request.setAttribute("produto", produto);
                    request.setAttribute("meusFornecedores", meusFornecedores);
                    RequestDispatcher rc = request.getRequestDispatcher("formcompra.jsp");
                    rc.forward(request, response);
                } 
                else {
                    mensagem = "Erro ao comprar produto!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rx = request.getRequestDispatcher("mensagem.jsp");
                    rx.forward(request, response);
                }
                
                break;
        
        
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link = "ProdutoController?acao=mostrar";
        
        try{
        
            Compra comprap = new Compra();
            java.util.Date utilDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Produto produto = new Produto();
            
            comprap.setIdcompra(Integer.parseInt(request.getParameter("id")));
            comprap.setQuantidadecompra(Integer.parseInt(request.getParameter("quantidadedesejada")));
            comprap.setDatacompra(sqlDate);
            double doubleValue = (Double.parseDouble(request.getParameter("preco")));
            int intValue = (int) Math.round(doubleValue);
            comprap.setValorcompra(intValue);
            comprap.setIdfornecedor(Integer.parseInt(request.getParameter("idfornecedor")));
            comprap.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
            comprap.setIdcomprador(Integer.parseInt(request.getParameter("idcomprador")));
            
            ProdutoDAO produtodao = new ProdutoDAO();
            
            produto = produtodao.getProdutoPorID(Integer.parseInt(request.getParameter("idproduto")));
            produto.setQuantidade_disponivel(produto.getQuantidade_disponivel()+(Integer.parseInt(request.getParameter("quantidadedesejada"))));
            produto.setPreco_compra(doubleValue);
            
                        
            
            CompraDAO compradao = new CompraDAO();

            
            
            if(compradao.gravar(comprap)) {
                produtodao.gravar(produto);
                mensagem = "Compra realizada com sucesso!";
            }
            else {
                mensagem = "Erro ao realizar compra!";
            }
            
            
            
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
                   
        }  catch (Exception e) {
            mensagem = "Erro ao gravar compra!";
            request.setAttribute("mensagem", mensagem);
            System.out.println("Erro: "+e.getMessage());
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        } 
    }
        
    
    
         


}
