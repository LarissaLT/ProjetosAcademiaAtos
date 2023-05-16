package br.com.atos.produto;

import br.com.atos.bd.BancoDados;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/produtos")
public class ProdutoController extends HttpServlet {

    private ProdutoRepository repository;

    public void init() {
        try {
            repository = (ProdutoRepository) new ProdutoService(new BancoDados());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /*
        *  método service analisa o tipo de requisição para que as
        *  devidas ações sejam executadas
        */

        String method = req.getMethod();
        switch (method){
            case "POST":
                doPost(req, res);
                break;
            case "GET":
                doGet(req, res);
                break;
            case "PUT":
                doPut(req, res);
                break;
            case "DELETE":
                doDelete(req, res);
                break;
            default:
                // redirecionar para um  Not found personalizado
                break;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProdutoModel> produtos = repository.listar();
        /* A lista de produtos obtida no passo anterior é armazenada no objeto req com o nome "produtos"*/
        req.setAttribute("produtos", produtos);
        /* getRequestDispatcher Ele é usado para encaminhar a solicitação e resposta para outra página JSP */
        RequestDispatcher dispatcher = req.getRequestDispatcher("/produtos.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("PUT".equals(method)) {
            System.out.println("atualizar");
            doPut(req,resp);
        } else if ("DELETE".equals(method)) {
            System.out.println("deletar");
            doDelete(req, resp);
        } else {
            System.out.println("cadastrar");
            ProdutoModel produto = new ProdutoModel();
            produto.setCodigo(Integer.parseInt(req.getParameter("codigo")));
            produto.setNome(req.getParameter("nome"));
            produto.setCategoria(req.getParameter("categoria"));
            produto.setValor(Float.parseFloat(req.getParameter("valor")));
            produto.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
            System.out.println(produto);

            repository.cadastrar(produto);
            resp.sendRedirect(req.getContextPath() + "/produtos");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdutoModel produto = new ProdutoModel();
        produto.setId(Integer.parseInt(req.getParameter("id")));
        produto.setCodigo(Integer.parseInt(req.getParameter("codigo")));
        produto.setNome(req.getParameter("nome"));
        produto.setCategoria(req.getParameter("categoria"));
        produto.setValor(Float.parseFloat(req.getParameter("valor")));
        produto.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));

        repository.atualizar(produto);
        resp.sendRedirect(req.getContextPath() + "/produtos");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("INICIAR EXCLUSAO");
        int id = Integer.parseInt(req.getParameter("id"));
        repository.excluir(id);
        resp.sendRedirect(req.getContextPath() + "/produtos");
        System.out.println("FIM EXCLUSAO");
    }

}
