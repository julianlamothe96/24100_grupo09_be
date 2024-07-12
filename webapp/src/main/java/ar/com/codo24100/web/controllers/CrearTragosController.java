package ar.com.codo24100.web.controllers;

import java.io.IOException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import ar.com.codo24100.web.dto.TragosDTO;
import ar.com.codo24100.web.service.TragosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CrearTragosController") //1
public class CrearTragosController extends HttpServlet {
    
    @Override
    protected void doPost(
        HttpServletRequest req, // esto tiene los datos del front
        HttpServletResponse resp // va todo lo que el back quiera enviarle al front
    ) throws ServletException, IOException {
       
        String jsonQueMandaElFront = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        System.out.println(jsonQueMandaElFront);
        
        // usamos jackson para convertir el texto que viene desde el front en 
        // un objeto java "mágicamente" creado
        ObjectMapper mapper = new ObjectMapper();

        // crear el DTO
        TragosDTO dto = mapper.readValue(jsonQueMandaElFront, TragosDTO.class);

        TragosService service = new TragosService();
        
        service.crearTrago(dto);
      
        // respondemos algo al front por medio del código de estado
        // http status code: 100,200,300,400,500
        resp.setStatus(HttpServletResponse.SC_CREATED); // creado
    }
}