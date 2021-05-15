package Control;

import Aplicacao.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ClienteDAO;

@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteDAO clientedao = new ClienteDAO();
        String acao = (String) request.getParameter("acao");
        int id;
        ArrayList<Cliente> meusClientes;
        String mensagem;
        String link  = "ClienteController?acao=mostrar";

        Cliente cliente = new Cliente();
        
        
        switch (acao) {
            case "mostrar":
                meusClientes = clientedao.getLista();
                request.setAttribute("meusClientes", meusClientes);
                RequestDispatcher mostrar = getServletContext().getRequestDispatcher("/listacliente.jsp");
                mostrar.forward(request, response);
                break;

            case "incluir":
                cliente.setIdcliente(0);                           
                cliente.setNome("");
                cliente.setCpf("");
                cliente.setEndereco("");
                cliente.setBairro("");
                cliente.setCidade("");
                cliente.setUf("");
                cliente.setCep("");
                cliente.setTelefone("");
                cliente.setEmail("");

                request.setAttribute("cliente", cliente);
                RequestDispatcher incluir = getServletContext().getRequestDispatcher("/formcliente.jsp"); 
                incluir.forward(request, response);
                break;

            case "editar":

                id = Integer.parseInt(request.getParameter("id"));
                cliente = clientedao.getClientePorID(id);

                if (cliente.getIdcliente() > 0) {
                    request.setAttribute("cliente", cliente);
                    RequestDispatcher rs = request.getRequestDispatcher("formcliente.jsp");
                    rs.forward(request, response);
                } else {
                    mensagem = "Erro ao gravar cliente!";
                    request.setAttribute("mensagem", mensagem);
                    request.setAttribute("link", link);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
                    rd.forward(request, response);
                }
                break;

            case "excluir":

                id = Integer.parseInt(request.getParameter("id"));
                clientedao.excluir(id);

                meusClientes = clientedao.getLista();
                request.setAttribute("meusClientes", meusClientes);
                RequestDispatcher aposexcluir = getServletContext().getRequestDispatcher("/listacliente.jsp"); 
                aposexcluir.forward(request, response);
                break;
        } 
        
        
    }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        String link  = "ClienteController?acao=mostrar";
        try {
            Cliente cliente = new Cliente();

            cliente.setIdcliente(Integer.parseInt(request.getParameter("id")));
            cliente.setNome(request.getParameter("nome"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEndereco(request.getParameter("endereco"));
            cliente.setBairro(request.getParameter("bairro"));
            cliente.setCidade(request.getParameter("cidade"));
            cliente.setUf(request.getParameter("uf"));
            cliente.setCep(request.getParameter("cep"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setEmail(request.getParameter("email"));

            ClienteDAO clientedao = new ClienteDAO();

            if (clientedao.gravar(cliente)) {
                mensagem = "Cliente gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar cliente!";
            }

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp"); 
            rd.forward(request, response);

        } catch (Exception e) {
            mensagem = "Erro ao gravar cliente!";
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mensagem.jsp");
            rd.forward(request, response);
        }
        
    }



}
