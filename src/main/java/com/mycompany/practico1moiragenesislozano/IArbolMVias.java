
package com.mycompany.practico1moiragenesislozano;

import java.util.List;
import practico1.excepciones.ExcepcionClaveNoExiste;

/**
 *
 * @author Moira
 * @param <K>
 * @param <V>
 */
public interface IArbolMVias<K extends Comparable<K>, V> {
    void insertar(K claveAInsertar, V valorAInsertar);
    V eliminar(K claveAEliminar) throws ExcepcionClaveNoExiste;
    V buscar(K claveABuscar);
    boolean contiene(K claveABuscar);
    int size();
    int altura();
    int nivel();
    void vaciar();
    boolean esArbolVacio();
    List<K> recorridoPorNiveles();
    List<K> recorridoEnPreOrden();
    List<K> recorridoEnInOrden();
    List<K> recorridoEnPostOrden();
    K mayorLLave();
    boolean hayHojasEnUltimoNivel();
    boolean sonIguales(ArbolMViasBusqueda<K,V> arbolCopia);

}
