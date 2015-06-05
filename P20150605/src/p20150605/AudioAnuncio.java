package p20150605;

import java.io.File;
import java.util.Date;

/**
 *  La clase AudioSpot sirve de base para gestionar cuñas de anuncios 
 * publicitarios en radio, almacenar metadatos sobre le nuncio y una refrencia 
 * al archivo de audio que lo contine. Además, permite programar la cuña
 * dentro de una secuencia de audio clips y exportarla aun formato propio.
 * 
 * @author Ginés Cuenca Martínez
 * @version 1.0.1
 * 
 */

/**
 * La clase AudioAnuncio sirve de base para gestionar cuñas de anuncios 
 publicitarios en radio, almacenar metadatos sobre le nuncio y una refrencia 
 al archivo de audio que lo contine.Además, permite programar la cuña
 dentro de una secuencia de audio clips y exportarla aun formato propio.
 * @author Ginés Cuenca Martínez
 * @version 1.0.1
 */
public class AudioAnuncio extends NewClass
{
    
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * Establece los metadatos del spot (nombre del producto y nombre 
     * del anunciantes)
     * 
     * @param producto
     * @param anunciante 
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }

    protected int RutinaComprobacion() {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    /**
     * ExportaAFormatoDAW realiza una comprobación de todos los datos del spot
     * , en caso de dar error mostrará un error a través de un valor entero 
     * negativo, si los datos son correctos se exportará en el nuevo formato.
     * 
     * @param objeto_daw
     * @return 
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = RutinaComprobacion();
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
