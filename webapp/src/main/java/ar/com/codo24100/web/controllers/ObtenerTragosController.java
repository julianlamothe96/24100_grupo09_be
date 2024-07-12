package ar.com.codo24100.web.controllers;

import ar.com.codo24100.web.domain.Tragos;
import ar.com.codo24100.web.service.TragosService;

public class ObtenerTragosController {
    // ?id=1&otroX=valor....

    // doGet
    public static void main(String[] args) {

        // Quiero obtener un trago de la base de datos con id=1
        Long id = 1L; // Recibo desde el request que mando algún frontend

        TragosService service = new TragosService();

        Tragos trago = service.obtenerTragoPorID(id);

        System.out.println(trago);
    }
}