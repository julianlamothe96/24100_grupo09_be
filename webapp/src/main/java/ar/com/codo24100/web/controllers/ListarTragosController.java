package ar.com.codo24100.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24100.web.domain.Tragos;
import ar.com.codo24100.web.service.TragosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarTragosController")
public class ListarTragosController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configurar cabeceras CORS
        resp.setHeader("Access-Control-Allow-Origin", "*"); // Permitir acceso desde cualquier origen
        resp.setHeader("Access-Control-Allow-Methods", "GET"); // Métodos permitidos (solo GET en este caso)
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Cabeceras permitidas

        // Crear servicio
        TragosService service = new TragosService();

        // Invocar método listarTragos > lista
        ArrayList<Tragos> tragos = service.listarTragos();

        ObjectMapper mapper = new ObjectMapper();

        // Convertir objeto Java a JSON string
        String tragosJSON = mapper.writeValueAsString(tragos);

        // Enviar respuesta al frontend
        resp.getWriter().println(tragosJSON);
    }

}

