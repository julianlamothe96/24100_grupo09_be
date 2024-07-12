package ar.com.codo24100.web.controllers;

import ar.com.codo24100.web.dto.TragosDTO;
import ar.com.codo24100.web.service.TragosService;

public class ActualizarTragoController {

    public static void main(String[] args) {
        // Datos que quiero actualizar, viene desde el front
        Long idTrago = 2L;
        String nombreTrago = "nuevo nombre del trago";

        // Ahora lo sé siempre
        TragosService service = new TragosService();

        TragosDTO trago = new TragosDTO(idTrago, nombreTrago);

        service.actualizarTrago(trago);
    }
}
