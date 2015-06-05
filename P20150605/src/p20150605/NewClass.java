/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class NewClass {
    protected static final int valormaximo = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public NewClass() {
    }

    /**
     * Establece los metadatos del spot (nombre del producto y nombre
     * del anunciantes)
     *
     * @param producto
     * @param anunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Establece la duración del spot
     *
     * @param duracion
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > valormaximo) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Etablece el vínculo creado con el fichero de audio
     *
     * @param nombre_archivo
     * @return
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * ProgramaEnCola realiza una comprobación de todos los datos del spot
     * , en caso de dar error mostrará un error a través de un valor entero
     * negativo, si los datos son correctos se podrá programar.
     *
     * @param cola_reproduccion
     * @return
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date tipofecha) {
        int resultado = RutinaComprobacion();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int RutinaComprobacion();

    /**
     * ExportaAFormatoDAW realiza una comprobación de todos los datos del spot
     * , en caso de dar error mostrará un error a través de un valor entero
     * negativo, si los datos son correctos se exportará en el nuevo formato.
     *
     * @param objeto_daw
     * @return
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
