
package Control;

import Aplicacao.Venda;
import Model.VendaDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VendaUpdate", urlPatterns = {"/VendaUpdate"})
public class VendaUpdate extends HttpServlet {

    /* Servlet de update da Venda com APENAS o método POST */
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "VendaController?acao=mostrar";
        try {
            Venda venda = new Venda();
            java.util.Date utilDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            venda.setIdvenda(Integer.parseInt(request.getParameter("id")));
            venda.setQuantidadevenda(Integer.parseInt(request.getParameter("quantidadedesejada")));
            venda.setDatavenda(sqlDate);
            double doubleValue = (Double.parseDouble(request.getParameter("preco")));
            float floatValue = (float)doubleValue;
            venda.setValorvenda(floatValue);
            venda.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
            venda.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
            venda.setIdvendedor(Integer.parseInt(request.getParameter("idvendedor")));


            VendaDAO vendadao = new VendaDAO();

            if (vendadao.gravar(venda)) {
                mensagem = "Venda atualizada com sucesso!";
            } else {
                mensagem = "Erro ao atualizar venda!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao atualizar venda!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
       
    }

}
