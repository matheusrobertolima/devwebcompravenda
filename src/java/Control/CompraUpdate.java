
package Control;

import Aplicacao.Compra;
import Model.CompraDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CompraUpdate", urlPatterns = {"/CompraUpdate"})
public class CompraUpdate extends HttpServlet {

    /* Servlet de update da Compra com APENAS o método POST */
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "CompraController?acao=mostrar";
        try {
            Compra compra = new Compra();
            java.util.Date utilDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            compra.setIdcompra(Integer.parseInt(request.getParameter("id")));
            compra.setQuantidadecompra(Integer.parseInt(request.getParameter("quantidadedesejada")));
            compra.setDatacompra(sqlDate);
            double doubleValue = (Double.parseDouble(request.getParameter("preco")));
            int intValue = (int) Math.round(doubleValue);
            compra.setValorcompra(intValue);
            compra.setIdfornecedor(Integer.parseInt(request.getParameter("idfornecedor")));
            compra.setIdproduto(Integer.parseInt(request.getParameter("idproduto")));
            compra.setIdcomprador(Integer.parseInt(request.getParameter("idcomprador")));


            CompraDAO compradao = new CompraDAO();

            if (compradao.gravar(compra)) {
                mensagem = "Compra atualizada com sucesso!";
            } else {
                mensagem = "Erro ao atualizar compra!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao atualizar compra!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
       
    }

}
