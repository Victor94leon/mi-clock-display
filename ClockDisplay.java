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
    // Dato para guardar la opción de ver lahora en formato 24 ó 12
    private boolean formato;
    
    /**
     * Crea una objeto de la clase ClockDisplay que fija la hora en 00:00 y
     * da la opción de ver la hora en formato 12(true) ó 24(false)
     */
    public ClockDisplay (boolean formato12)
    {
        formato = formato12;
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        updateHoraActual();
    }
    
    /**
     * Crea una objeto de la clase ClockDisplay con dos parametros para fijar 
     * la hora y la opción de ver la hora en formato 12(true) ó 24(false)
     */
    public ClockDisplay (int parHora,int parMinuto,boolean formato12)
    {
        formato = formato12;
        horas = new NumberDisplay(24);
        minutos = new NumberDisplay(60);
        horas.setValue(parHora);
        minutos.setValue(parMinuto);
        updateHoraActual();
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
        updateHoraActual();
    }
    
    /**
     * Método que devuelve la hora con una cadena de caracteres
     */
    public String getTime ()
    {
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
        updateHoraActual();
    }
    
    /**
     * Actualiza el atributo horaActual siguiendo las normas de un
     * reloj de 12 horas.
     */
    public void updateHoraActual()
    {
        if (formato) {
            String formatoReloj = "a.m";
            int horaAhora = horas.getValue(); 
            if (horaAhora >= 12){
                formatoReloj = "p.m.";
            }
            
            if (horaAhora > 12) {
                horaAhora = horaAhora - 12;
            }
            else if (horaAhora == 0) {
                horaAhora = 12;
            }
            timeNow = horaAhora + ":" + minutos.getDisplayValue() + " " + formatoReloj;
        }
        else {
            timeNow = horas.getDisplayValue() + ":" + minutos.getDisplayValue();
        }
    }
    
    /**
     * Método que permite alternar entre los modos del reloj
     */
    public void changeFormat ()
    {
        formato = !formato;
    	updateHoraActual();
    }

}