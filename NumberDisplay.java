/**
 * Crea un nuevo repositorio en GitHub llamado mi-clock-display.
 *
 *Luego codifica en BlueJ la clase NumberDisplay realizando los commits que creas oportunos. A continuación se indica qué es necesario que, como mínimo, implemente dicha clase:
 *
 *Un constructor que recibe por parámetro el límite del display y que fija el valor actual del display a 0.
 *Un método setter que fija el valor actual del display al valor pasado como parámetro (nombre del método: setValue).
 *Un método que devuelve el valor actual del display en forma de cadena de 2 caracteres (nombre del método: getDisplayValue).
 *Un método que devuelve el valor actual del display como entero (nombre del método: getValue),
 *Un método que incrementa en 1 al display y lo hace volver al principio si alcanza el límite (nombre del método: increment)
 *Una vez que hayas comprobado que funciona, sube el repositorio a GitHub e indica la URL del último commit como respuesta de esta actividad.
 */

public class NumberDisplay {
    // Atributo que marca el límite.
    private int limit;
    //
    private int display;
    
    /**
     * Crea un objeto de la clase NumberDisplay con un parametro para fijar el límite
     */
    public NumberDisplay (int lim)
    { 
        limit = lim; //límite del display
        display = 0;
    }
    
    /**
     * Método setter que fija el valor actual del display al valor pasado como parametro
     */
    public void setValue (int value)
    {
        if (display >= 0 && display < limit) {
            display = value;
        }
        else {
            System.out.println("El valor tiene que ser mayor que 0 y menor que el límite");
        }
    }
    
    /**
     * Método que devuelve el valor actual de display en forma de cadena de 2 caracteres
     */
    public String getDisplayValue ()
    {
        String displayValue;
        if (display >= 0 && display < 10) {
            displayValue = "0" + display;
        }
        else {
            displayValue = "" + display;
        }
        return displayValue;
    }
}