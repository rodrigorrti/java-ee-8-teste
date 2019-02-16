package br.com.agenda.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="oiServlet3", urlPatterns = {"/oi3","/ola"})
public class OiServlet3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        //	escreve	o	texto
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Terceira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Oi	mundo Servlet 3.0 com anotations /oi3 /ola!</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
