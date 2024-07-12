package ar.com.codo24100.web.domain;

public class Tragos {

    private Long idTrago;
    private String nombreTrago;

    // Constructor para obtener desde la DB
    public Tragos(Long idTrago, String nombreTrago) {
        this.idTrago = idTrago;
        this.nombreTrago = nombreTrago;
    }

    // Constructor para crear en la DB
    public Tragos(String nombreTrago) {
        this.nombreTrago = nombreTrago;
    }

    public Long getIdTrago() {
        return idTrago;
    }

    public void setIdTrago(Long idTrago) {
        this.idTrago = idTrago;
    }

    public String getNombreTrago() {
        return nombreTrago;
    }

    public void setNombreTrago(String nombreTrago) {
        this.nombreTrago = nombreTrago;
    }

    @Override
    public String toString() {
        return "Tragos [idTrago=" + idTrago + ", nombreTrago=" + nombreTrago + "]";
    }
}
