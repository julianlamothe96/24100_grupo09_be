package ar.com.codo24100.web.dto;

// Inmutables
public class TragosDTO {
    private Long idTrago;
    private String nombreTrago;
    
    // Necesitamos un constructor por defecto para poder usar Jackson
    public TragosDTO() {
    }

    public TragosDTO(Long idTrago, String nombreTrago) {
        this.idTrago = idTrago;
        this.nombreTrago = nombreTrago;
    }

    public TragosDTO(String nombreTrago) {
        this.nombreTrago = nombreTrago;
    }

    public Long getIdTrago() {
        return idTrago;
    }

    public String getNombreTrago() {
        return nombreTrago;
    }
}
