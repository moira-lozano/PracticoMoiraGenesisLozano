/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practico1.excepciones;

/**
 *
 * @author Moira
 */
public class ExcepcionOrdenInvalido extends Exception{
    /**
     * Creates a new instance of <code>ExcepcionOrdenInvalido</code> without
     * detail message.
     */
    public ExcepcionOrdenInvalido() {
        super("Orden del árbol debe ser mayor o igual a 3");
    }

    /**
     * Constructs an instance of <code>ExcepcionOrdenInvalido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionOrdenInvalido(String msg) {
        super(msg);
    }
}
