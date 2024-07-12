package ar.com.codo24100.web.controllers;

import ar.com.codo24100.web.dto.TragosDTO;
import ar.com.codo24100.web.service.TragosService;
import ar.com.codo24100.web.domain.Tragos;
import java.util.ArrayList;

// Crear un Servlet
// api/trago
public class TragosController {
    
    private TragosService service;
    
    public TragosController() {
        this.service = new TragosService();
    }

    public TragosDTO get(Long idTrago) {
        Tragos trago = service.obtenerTragoPorID(idTrago);
        if (trago != null) {
            return new TragosDTO(trago.getIdTrago(), trago.getNombreTrago());
        }
        return null;
    }

    public void post(TragosDTO tragoDto) {
        service.crearTrago(tragoDto);
    }

    public void put(Long idTrago, TragosDTO tragoDto) {
        // Se asume que tragoDto ya contiene el ID actualizado
        service.actualizarTrago(tragoDto);
    }

    public void delete(Long idTrago) {
        service.eliminarTragoPorID(idTrago);
    }

    public ArrayList<TragosDTO> getAll() {
        ArrayList<Tragos> tragos = service.listarTragos();
        ArrayList<TragosDTO> tragosDto = new ArrayList<>();
        for (Tragos trago : tragos) {
            tragosDto.add(new TragosDTO(trago.getIdTrago(), trago.getNombreTrago()));
        }
        return tragosDto;
    }
}
