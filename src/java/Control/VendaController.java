package Control;

import Aplicacao.Venda;
import Aplicacao.Produto;
import Aplicacao.Cliente;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.VendaDAO;
import Model.ProdutoDAO;
import Model.ClienteDAO;

@WebServlet(name = "VendaController", urlPatterns = {"/VendaController"})
public class VendaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        VendaDAO vendadao = new VendaDAO();
        ProdutoDAO produtodao = new ProdutoDAO();
        ClienteDAO clientedao = new ClienteDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Venda> minhasVendas;
        ArrayList<Cliente> meusClientes;
        Produto produto = new Produto();
        Venda venda = new Venda();
        String mensagem;
        String link  = "VendaController?acao=mostrar";
              
        
        switch(acao) {
            case "mostrar":
                minhasVendas = vendadao.getLista();
                request.setAttribute("minhasVendas", minhasVendas);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/listavenda.jsp");
                mostrar.forward(request, response);
                break;
            
            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                venda = vendadao.getVendaPorID(id);

                if (venda.getIdvenda() > 0) {
                    request.setAttribute("venda", venda);
                    RequestDispatcher rs = request.getRequestDispatcher("formvendaupdate.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar venda!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;
                
            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));               
                vendadao.excluir(id);

                minhasVendas = vendadao.getLista();
                request.setAttribute("minhasVendas", minhasVendas);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/listavenda.jsp"); 
                aposexcluir.forward(request, response);
                break;
                
            case "venderproduto":
                
                venda.setIdvenda(0);
                id = Integer.parseInt(request.getParameter("id"));
                produto = produtodao.getProdutoPorID(id);
                meusClientes = clientedao.getLista();
                
                if(produto.getIdproduto() > 0 && produto.getQuantidade_disponivel() > 0 && produto.getLiberado_venda().equals("S")) {
                    request.setAttribute("venda", venda);
                    request.setAttribute("produto", produto);
                    request.setAttribute("meusClientes", meusClientes);
                    RequestDispatcher rc = request.getRequestDispatcher("formvenda.jsp");
                    rc.forward(request, response);
                } 
                else {
                   

                    RequestDispatcher rx = request.getRequestDispatcher("ProdutoController?acao=mostrar");
                    rx.forward(request, response);
                }
                
                break;
                
                case "relatoriovenda":
                minhasVendas = vendadao.getLista();
                request.setAttribute("minhasVendas", minhasVendas);
                RequestDispatcher mostrarrelatorio = getServletContext().getRequestDispatcher("/relatoriovenda.jsp");
                mostrarrelatorio.forward(request, response);
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
        
            Venda vendap = new Venda();
            java.util.Date utilDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Produto produto = new Produto();
            
            vendap.setIdvenda(Integer.parseInt(request.getParameter("id")));
            vendap.setQuantidadevenda(Integer.parseInt(request.getParameter("quantidadedesejada")));
            vendap.setDatavenda(sqlDate);
            double doubleValue = (Double.parseDouble(request.getParameter("preco")));
            float floatValue = (float)doubleValue;
            vendap.setValorvenda(floatValue);
            vendap.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
            vendap.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
            vendap.setIdvendedor(Integer.parseInt(request.getParameter("idvendedor")));
            
            ProdutoDAO produtodao = new ProdutoDAO();
            
            produto = produtodao.getProdutoPorID(Integer.parseInt(request.getParameter("idproduto")));
            produto.setQuantidade_disponivel(produto.getQuantidade_disponivel()-(Integer.parseInt(request.getParameter("quantidadedesejada"))));
            
                        
            
            VendaDAO vendadao = new VendaDAO();

            if(produto.getQuantidade_disponivel() >= 0){
            
            if(vendadao.gravar(vendap)) {
                produtodao.gravar(produto);
                mensagem = "Venda realizada com sucesso!";
            }
            else {
                mensagem = "Erro ao realizar venda!";
            }
            
            }
            else {
                mensagem = "Quantidade desejada excede a quantidade em estoque, por favor tente novamente.";
            
            }
            
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
                   
        }  catch (Exception e) {
            mensagem = "Erro ao gravar venda!";
            request.setAttribute("mensagem", mensagem);
            System.out.println("Erro: "+e.getMessage());
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        } 
    }
        
    
    
         


}
