/**
 * Añade al proyecto donde desarrollaste la clase NumberDisplay una nueva clase llamada ClockDisplay. Esta nueva clase debe:
 *
 *Tener 2 atributos de tipo NumberDisplay, uno para las horas y otro para los minutos.
 *Tener un atributo de tipo String donde se almacena la hora actual del reloj con 5 caracteres.
 *Tener 2 constructores: uno sin parámetros, que fija la hora a "00:00" y otro con 2 parámetros de tipo int, que representan las horas y los minutos a los que fijar la hora actual.
 *Tener un método setTime que acepte dos parámetros de tipo int, que representan horas y minutos, y que fije dichos valores como el tiempo actual del reloj.
 *Tener un método getTime que devuelva la hora como String de 5 caracteres. 
 *Tener un método timeTick que haga avanzar un minuto la hora actual (sea esta la que sea originalmente). 
 */

public class ClockDisplay {
    // Display para las horas
    private NumberDisplay horas;
    // Display para los minutos
    private NumberDisplay minutos;
    // Datos guardados en un String para mostar la hora
    private String timeNow;
    // Parametro booleano para indicar si el objeto muestra la hora en formato 00:00 o AM/PM
    private boolean formatoAMPM;
    
    /**
     * Crea una objeto de la clase ClockDisplay que da la opción de mostrar la hora en formato 00:00(false) o en AM/PM(true)
     */
    public ClockDisplay (boolean formatoReloj)
    {
        formatoAMPM = formatoReloj;
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Crea una objeto de la clase ClockDisplay con tre parametros para fijar una hora y la opción de mostrar la hora en formato 00:00(false) o en AM/PM(true) 
     */
    public ClockDisplay (int parHora,int parMinuto,boolean formatoReloj)
    {
        formatoAMPM = formatoReloj;
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        horas.setValue(parHora);
        minutos.setValue(parMinuto);
        timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Método setter que fija los parámetros introducidos como lahora nueva actual
     */
    public void setTime (int parHora,int parMinuto)
    {
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        horas.setValue(parHora);
        minutos.setValue(parMinuto);
        timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
    
    /**
     * Método que devuelve la hora con una cadena de caracteres segun AM/PM
     */
    public String getTime ()
    {
        if (formatoAMPM == true) { 
            int formatoPM = horas.getValue();
            if (formatoPM == 00) {
                timeNow = 12 + ":" + minutos.getDisplayValue() + " de medianoche";
            }
            else {
                if (formatoPM > 12) {
                    int horaCambiada;
                    horaCambiada = formatoPM - 12;
                    timeNow = horaCambiada + ":" + minutos.getDisplayValue() + " pm";
                }
                else {
                    if (formatoPM == 12){
                        timeNow = "12" + ":" + minutos.getDisplayValue() + " del mediodía";
                    }
                    else {
                        int horaCambiada;
                        horaCambiada = formatoPM;
                        timeNow= horaCambiada + ":" + minutos.getDisplayValue() + " am";
                    }
                }
            }
            timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        }
        return timeNow;
    }
    
    /**
     * Método que hace avanzar en un minuto la hora actual
     */
    public void timeTick ()
    {
        minutos.increment();
        if (minutos.getValue() == 0) {
            horas.increment();
        }
        timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
    }
}