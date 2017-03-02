
public class Acceso
{
    // guarda el año
    private int anioAcceso;
    // variable que guarda el mes
    private int mesAcceso;
    //variable que guarda el día
    private int diaAcceso;
    //variable que guarda la hora
    private int horaAcceso;
    //variable que guarda los minutos
    private int minutosAcceso;
   
    /**
     *  constructor al que se le pasen 5 parámetros de tipo entero.
     */
    public Acceso(int anio, int mes, int dia, int hora, int minutos)
    {
       anio = anioAcceso;
       mes = mesAcceso;
       dia = diaAcceso;
       hora = horaAcceso;
       minutos = minutosAcceso;
    }
    
    /**
     * Método getter que informe de la hora de acceso.
     */
    public int getHoraAcceso()
    {
        return horaAcceso;
    }
    
}
