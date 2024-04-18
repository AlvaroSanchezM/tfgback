package es.upm.dit.isst.tfgapi;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import es.upm.dit.isst.tfgapi.model.TFG;
import es.upm.dit.isst.tfgapi.model.Estado;
import es.upm.dit.isst.tfgapi.repository.TFGRepository;

@SpringBootTest
public class TestTFGService {
 
    @Autowired
    private TFGRepository repo;
 
    @Test
    final void testTFG() {
       
        TFG tfg = new TFG();//Este es el eistema bajo pruebas
        tfg.setAlumno("alumno@alumnos.upm.es");//Defino todas las variables del sistema
        tfg.setTutor("profe@upm.es");
        tfg.setTitulo("Diseño de un sistema");
        tfg.setEstado(Estado.SOLICITADO);

        repo.save(tfg);//Ejecuto lo que quiero probar

        Optional<TFG> tfg2 = repo.findById("alumno@alumnos.upm.es");
        assertTrue(tfg2.isPresent());//Verifico que lo que esperaba que se hiciera se ha hecho
       
        tfg.setTitulo("Análisis de un sistema");//Actualizo el tfg
        repo.save(tfg);//Lo vuelvo a guardar
        tfg2 = repo.findById("alumno@alumnos.upm.es");
        assertNotEquals(tfg2.get().getTitulo(), "Diseño de un sistema");//Verifico que se ha cambiado el título de tfg
               
        repo.delete(tfg);//Probamos el método de borrar tfg
        tfg2 = repo.findById("alumno@alumnos.upm.es");
        assertFalse(tfg2.isPresent());//Verifico que no está el tfg

    }
}