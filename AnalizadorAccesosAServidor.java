import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> numeroAccesos;
    public AnalizadorAccesosAServidor()
    {
        //Array para almacenar cada linea del log
        numeroAccesos = new ArrayList<Acceso>();
    }
    
    /**
     * Método que requiere de un parámetro String que informe del nombre del archivo de log 
     * a leer. Este método lee el archivo de log.
     */
    public void analizarArchivoDeLog (String nombrelog)
    {
        try {
            File archivo = new File(nombrelog);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                int cont = 0;
               
                while(cont < 5)
                {
                    //guarda cada línea del archivo log en el array
                    String entradaLog[] = sc.nextLine().split(" ");
                     //Creo un objeto de la clase acceso pasando los parámetros a entero.
                    Acceso entradaActualLog = new Acceso(Integer.parseInt(entradaLog[0]),Integer.parseInt(entradaLog[1]),
                    Integer.parseInt(entradaLog[2]),Integer.parseInt(entradaLog[3]),
                    Integer.parseInt(entradaLog[4]));
                    //añade la línea al arraylist
                    numeroAccesos.add(entradaActualLog);
                }
               
                cont++;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que, a partir del análisis hecho por el método anterior encuentra la hora 
     * (solo la hora, sin tener en cuenta los minutos) a la que se producen más accesos al servidor. 
     * El método muestra por pantalla dicha hora y la devuelve. En caso de que se invoque este método 
     * sin haberse invocado el anterior el método informa por pantalla de que no tiene datos 
     * y no hace nada más.
     */
    public int obtenerHoraMasAccesos ()
    {
        int horaActual = 0;
        int cont = 0;
        int horaAccesos = -1;
        int contAccesos = 0;
        
        if(numeroAccesos.size()!=0){
            //cuenta las horas 
            for (int i = 0; i < 24; i++){
                horaActual = cont;
                //acumula las horas
                for (Acceso acceso : numeroAccesos){
                    if (acceso.getHoraAcceso() == horaActual){
                        cont++;
                    }
                }
                //cuando hay dos horas iguales coge la mayor
                if (cont >= contAccesos){
                    contAccesos = cont;
                    horaAccesos = horaActual;
                }

                cont = 0;
            }
        }

        if (horaAccesos == -1) {
            System.out.println("Me faltan datos para analizar");
        }
        else {
            System.out.println("Hora de más actividad: " + horaAccesos); 
        }
        return horaAccesos;

    }
}
