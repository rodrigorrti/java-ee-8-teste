package br.com.agenda.servlet;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.entity.Contato;
import br.com.agenda.util.UtilData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");

        String dataNascimentoStr = req.getParameter("dataNascimento");

        LocalDate dataNascimento;
        try {
            dataNascimento = UtilData.data(dataNascimentoStr);
        }catch (Exception e){
            out.println("Erro ao converter Data de Nascimento: \n" + e.getMessage());
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            return;
        }

        Contato c = new Contato(nome);
        c.setEmail(email);
        c.setEndereco(endereco);
        c.setDataNascimento(dataNascimento);

        ContatoDAO cDAO = new ContatoDAO();
        cDAO.setContato(c);

        //	escreve	o	texto
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Terceira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Contato adicionado	com	sucesso!");
        out.println("<p>Nome: "+c.getNome()+ "</p>");
        out.println("<p>Email: "+c.getEmail()+ "</p>");
        out.println("<p>Endereco: "+c.getEndereco()+ "</p>");
        out.println("<p>Data de Nascimento: "+UtilData.DDMMAAAA(c.getDataNascimento())+ "</p>");

        out.println("<p>Data de Nascimento: "+UtilData.DDMMAAAA(c.getDataNascimento())+ "</p>");
        out.println("<p><a href=\"index.jsp\">Home</a></p>");
        out.println("</body>");
        out.println("</html>");

    }
}
