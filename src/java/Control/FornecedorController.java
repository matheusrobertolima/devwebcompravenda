
package Control;

import Aplicacao.Fornecedor;
import Model.FornecedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FornecedorController", urlPatterns = {"/FornecedorController"})
public class FornecedorController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FornecedorDAO fornecedordao = new FornecedorDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Fornecedor> meusFornecedores;
        String mensagem;
        String link  = "FornecedorController?acao=mostrar";

        Fornecedor fornecedor = new Fornecedor();
        
        switch (acao) {
            case "mostrar":
                meusFornecedores = fornecedordao.getLista();
                request.setAttribute("meusFornecedores", meusFornecedores);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/listafornecedor.jsp");
                mostrar.forward(request, response);
                break;

            case "incluir":
                fornecedor.setIdfornecedor(0);                           
                fornecedor.setRazaosocial("");
                fornecedor.setCnpj("");
                fornecedor.setEndereco("");
                fornecedor.setBairro("");
                fornecedor.setCidade("");
                fornecedor.setUf("");
                fornecedor.setCep("");
                fornecedor.setTelefone("");
                fornecedor.setEmail("");

                request.setAttribute("fornecedor", fornecedor);
                RequestDispatcher incluir = getServletContext().getRequestDispatcher("/formfornecedor.jsp"); 
                incluir.forward(request, response);
                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                fornecedor = fornecedordao.getFornecedorPorID(id);

                if (fornecedor.getIdfornecedor() > 0) {
                    request.setAttribute("fornecedor", fornecedor);
                    RequestDispatcher rs = request.getRequestDispatcher("formfornecedor.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar fornecedor!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;

            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));
                fornecedordao.excluir(id);

                meusFornecedores = fornecedordao.getLista();
                request.setAttribute("meusFornecedores", meusFornecedores);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/listafornecedor.jsp"); 
                aposexcluir.forward(request, response);
                break;
        } 
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "FornecedorController?acao=mostrar";
        try {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setIdfornecedor(Integer.parseInt(request.getParameter("id")));
            fornecedor.setRazaosocial(request.getParameter("razao_social"));
            fornecedor.setCnpj(request.getParameter("cnpj"));
            fornecedor.setEndereco(request.getParameter("endereco"));
            fornecedor.setBairro(request.getParameter("bairro"));
            fornecedor.setCidade(request.getParameter("cidade"));
            fornecedor.setUf(request.getParameter("uf"));
            fornecedor.setCep(request.getParameter("cep"));
            fornecedor.setTelefone(request.getParameter("telefone"));
            fornecedor.setEmail(request.getParameter("email"));

            FornecedorDAO fornecedordao = new FornecedorDAO();

            if (fornecedordao.gravar(fornecedor)) {
                mensagem = "Fornecedor gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar fornecedor!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar fornecedor!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
        
    }
        
    }


