package ar.com.codo24100.web.controllers;

import java.io.IOException;

import ar.com.codo24100.web.service.TragosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarTragoController")
public class EliminarTragoController extends HttpServlet {

    protected void doDelete(
        HttpServletRequest req, // aquí viene el ?idTrago=
        HttpServletResponse resp
    ) throws ServletException, IOException {
       
        // quiero obtener un trago de la base de datos con idTrago=1
        String idTrago = req.getParameter("idTrago");

        TragosService service = new TragosService();

        service.eliminarTragoPorID(Long.parseLong(idTrago));

        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
