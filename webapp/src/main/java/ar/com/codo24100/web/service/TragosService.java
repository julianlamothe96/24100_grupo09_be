package ar.com.codo24100.web.service;

import java.util.ArrayList;

import ar.com.codo24100.web.dao.ICrud;
import ar.com.codo24100.web.dao.MySQLCrudImpl;
import ar.com.codo24100.web.domain.Tragos;
import ar.com.codo24100.web.dto.TragosDTO;

public class TragosService {

    private ICrud crud; // null, porque no es primitivo

    public TragosService() {
        // Interface nombre = new ClaseQueImplementaLaInterface();
        crud = new MySQLCrudImpl();
    }

    public void crearTrago(TragosDTO dto) {
        this.crud.create(dto);
    }

    public Tragos obtenerTragoPorID(Long idTrago) {
        return this.crud.getById(idTrago);
    }

    public void eliminarTragoPorID(Long idTrago) {
        this.crud.delete(idTrago);
    }

    public ArrayList<Tragos> listarTragos() {
        return this.crud.findAll();
    }

    public void actualizarTrago(TragosDTO trago) {
        this.crud.update(trago);
    }
}
