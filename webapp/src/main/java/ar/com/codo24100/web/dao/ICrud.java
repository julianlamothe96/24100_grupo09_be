
package ar.com.codo24100.web.dao;

import java.util.ArrayList;
import ar.com.codo24100.web.domain.Tragos;
import ar.com.codo24100.web.dto.TragosDTO;

public interface ICrud {

    public Tragos getById(Long id);

    public void create(TragosDTO dto);

    public void delete(Long pk);

    public ArrayList<Tragos> findAll();

    public void update(TragosDTO trago);

}