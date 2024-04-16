package es.upm.dit.isst.tfgapi.model;

import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class TFG {
    @Id @Email private String alumno;
    @Email @NotEmpty private String tutor;
    @NotEmpty private String titulo;
    private String resumen;
    private Estado status;
    @JsonIgnore @Lob byte[] memoria;
    @PositiveOrZero @DecimalMax("10.0") Double calificacion;
    @ManyToOne Sesion sesion;
    //getters, setters, equals, toString, hashcode
    public String getAlumno() {
        return alumno;
    }
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public String getTutor() {
        return tutor;
    }
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getResumen() {
        return resumen;
    }
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    public Estado getStatus() {
        return status;
    }
    public void setStatus(Estado status) {
        this.status = status;
    }
    public byte[] getMemoria() {
        return memoria;
    }
    @JsonProperty
    public void setMemoria(byte[] memoria) {
        this.memoria = memoria;
    }
    @JsonGetter("memoria")
    public URI getDireccionMemoria() throws URISyntaxException{
        return new URI("./memoria");
    }
    public Double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
    public Sesion getSesion() {
        return sesion;
    }
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }
    public TFG(@Email String alumno, @Email @NotEmpty String tutor, @NotEmpty String titulo, String resumen,
            Estado status, byte[] memoria, @PositiveOrZero @DecimalMax("10.0") Double calificacion, Sesion sesion) {
        this.alumno = alumno;
        this.tutor = tutor;
        this.titulo = titulo;
        this.resumen = resumen;
        this.status = status;
        this.memoria = memoria;
        this.calificacion = calificacion;
        this.sesion = sesion;
    }
    public TFG() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
        result = prime * result + ((tutor == null) ? 0 : tutor.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((resumen == null) ? 0 : resumen.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((calificacion == null) ? 0 : calificacion.hashCode());
        result = prime * result + ((sesion == null) ? 0 : sesion.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TFG other = (TFG) obj;
        if (alumno == null) {
            if (other.alumno != null)
                return false;
        } else if (!alumno.equals(other.alumno))
            return false;
        if (tutor == null) {
            if (other.tutor != null)
                return false;
        } else if (!tutor.equals(other.tutor))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (resumen == null) {
            if (other.resumen != null)
                return false;
        } else if (!resumen.equals(other.resumen))
            return false;
        if (status != other.status)
            return false;
        if (calificacion == null) {
            if (other.calificacion != null)
                return false;
        } else if (!calificacion.equals(other.calificacion))
            return false;
        if (sesion == null) {
            if (other.sesion != null)
                return false;
        } else if (!sesion.equals(other.sesion))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "TFG [alumno=" + alumno + ", tutor=" + tutor + ", titulo=" + titulo + ", resumen=" + resumen
                + ", status=" + status + ", calificacion=" + calificacion + ", sesion=" + sesion + "]";
    }
    
}
