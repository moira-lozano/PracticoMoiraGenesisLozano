/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practico1moiragenesislozano;
import java.util.List;
import practico1.excepciones.ExcepcionClaveNoExiste;
/**
 *
 * @author Moira
 * @param <K>
 * @param <V>
 */
public interface IArbolBusqueda <K extends Comparable<K>, V> {
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
  
    int cantidadDeNodosConAmbosHijos();
    int cantidadDeNodosConAmbosHijosRec();
    int cantidadNodosConAmbosHijosEnN(int nivel);
    int cantidadNodosConAmbosHijosEnNRec(int nivel);
    int cantidadNodosConUnHijoEnN(int nivel);
    int nroNodosConInOrden();   
    K sucesorInOrden(NodoBinario<K,V> nodoActual);
    
    K predecedorInOrden(NodoBinario<K,V> nodoActual);
    List<K> recorridoEnPostOrden();
    int cantidadNodosUnSoloHijoNoVacio();
    int cantidadHijosVacíosInOrden ();
    boolean verificarSiSonArbolesSimilares(ArbolBinarioBusqueda<K,V> arbol);
    
}
