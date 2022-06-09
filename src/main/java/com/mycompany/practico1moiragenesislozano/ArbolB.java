/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practico1moiragenesislozano;

import java.util.Stack;
import practico1.excepciones.ExcepcionClaveNoExiste;

/**
 *
 * @author Moira
 * @param <K>
 * @param <V>
 */
public class ArbolB <K extends Comparable<K>, V> extends ArbolMViasBusqueda<K,V>{
    private int nroMaximoDeDatos;
    private int nroMinimoDeDatos;
    private int nroMinimoDeHijos;
    
    public ArbolB() {
        super();
        this.nroMaximoDeDatos = 2;
        this.nroMinimoDeDatos = 1;
        this.nroMinimoDeHijos = 2;
    }
    
    public ArbolB(int orden) throws practico1.excepciones.ExcepcionOrdenInvalido {
        super(orden);
        this.nroMaximoDeDatos = super.orden - 1;
        this.nroMinimoDeDatos = this.nroMaximoDeDatos / 2;
        this.nroMinimoDeHijos = this.nroMinimoDeDatos + 1;
    }
    // 8. Para el árbol B implemente el método insertar
    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (valorAInsertar == null) {
            throw new RuntimeException("No se permite insertar valores nulos");
        }
        
        if (claveAInsertar == null) {
            throw new RuntimeException("No se permite insertar claves nulas");
        }
        if (this.esArbolVacio()) {
            this.raiz = new NodoMVias<>(this.orden + 1, claveAInsertar, valorAInsertar);
            return;
        }
        
        Stack<NodoMVias<K,V>> pilaDeAncestros = new Stack<>();
        NodoMVias<K,V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            int posicionDeClave = super.obtenerPosicionDeClave(nodoActual, claveAInsertar);
            if (posicionDeClave != POSICION_INVALIDA) {
                nodoActual.setValor(posicionDeClave, valorAInsertar);
                nodoActual = NodoMVias.nodoVacio();
            } else {
                if (nodoActual.esHoja()) {
                    this.insertarClaveYValorOrdenadaEnNodo(nodoActual, claveAInsertar, valorAInsertar);
                    if (nodoActual.cantidadDeClaveNoVacias() > this.nroMaximoDeDatos) {
                        this.dividir(nodoActual, pilaDeAncestros);
                    }
                    nodoActual = NodoMVias.nodoVacio();
                } else {
                    int posicionPorDondeBajar = this.obtenerPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    pilaDeAncestros.push(nodoActual);
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }
        }
    }

    private void dividir(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {       
        K clave = nodoActual.getClave(this.nroMinimoDeDatos - 1);
        V valor = nodoActual.getValor(this.nroMinimoDeDatos - 1);
        NodoMVias<K,V> nodoHijoMenor = new NodoMVias<>(this.orden + 1, clave, valor);               
        NodoMVias<K,V> nodoHijoMayor = new NodoMVias<>(this.orden + 1, clave, valor);       
        int posicion = 0;
        for (int i = 0; i < this.orden; i++) {
            if (i == this.nroMinimoDeDatos) {
                nodoActual.setClave(i - 1, nodoActual.getClave(i));
                nodoActual.setValor(i - 1, nodoActual.getValor(i));
                nodoActual.setClave(i, null);
                nodoActual.setValor(i, null);
            }           
            if (i > this.nroMinimoDeDatos) {
                nodoHijoMayor.setClave(posicion, nodoActual.getClave(i));
                nodoHijoMayor.setValor(posicion, nodoActual.getValor(i));
                nodoActual.setClave(i, null);
                nodoActual.setValor(i, null);
                posicion++;
            }
        }
        nodoActual.setHijo(this.nroMinimoDeDatos - 1, nodoHijoMenor);
        nodoActual.setHijo(this.nroMinimoDeDatos, nodoHijoMayor);
        pilaDeAncestros.push(nodoActual);
    }
    
    // 9. Para el árbol B implemente el método eliminar
    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoExiste {      
        if (claveAEliminar == null) {
            throw new IllegalArgumentException("Clave a eliminar no puede ser nula");
        }
        
        Stack<NodoMVias<K,V>> pilaDeAncestros = new Stack<>();
        NodoMVias<K,V> nodoActual = this.buscarNodoDeLaClave(claveAEliminar, pilaDeAncestros);
        if (NodoMVias.esNodoVacio(nodoActual)) {
            throw new ExcepcionClaveNoExiste();
        }
        int posicionDeClaveAEliminarEnElNodo = super.obtenerPosicionPorDondeBajar(nodoActual, claveAEliminar) - 1;
        V valorARetornar = nodoActual.getValor(posicionDeClaveAEliminarEnElNodo);
        if (nodoActual.esHoja()) {
            super.eliminarClaveYValorDelNodo(nodoActual, posicionDeClaveAEliminarEnElNodo);
            if (nodoActual.cantidadDeClaveNoVacias() < this.nroMinimoDeDatos) {
                if (pilaDeAncestros.empty()) {
                    if (nodoActual.cantidadDeClaveNoVacias() == 0) {
                        super.vaciar();
                    }
                } else {
                    this.prestarOFusionar(nodoActual, pilaDeAncestros);
                }
            }
        } else {
            pilaDeAncestros.push(nodoActual);
            NodoMVias<K,V> nodoDelPredecesor = this.buscarNodoDeClavePredecesora(pilaDeAncestros, 
                    nodoActual.getHijo(posicionDeClaveAEliminarEnElNodo));
            int posicionDelPredecesor = nodoDelPredecesor.cantidadDeClaveNoVacias() - 1;
            K clavePredecesora = nodoDelPredecesor.getClave(posicionDelPredecesor);
            V valorPredecesor = nodoDelPredecesor.getValor(posicionDelPredecesor);
            super.eliminarClaveYValorDelNodo(nodoDelPredecesor, posicionDelPredecesor);
            nodoActual.setClave(posicionDeClaveAEliminarEnElNodo, clavePredecesora);
            nodoActual.setValor(posicionDeClaveAEliminarEnElNodo, valorPredecesor);
            if (nodoDelPredecesor.cantidadDeClaveNoVacias() < this.nroMaximoDeDatos) {
                this.prestarOFusionar(nodoDelPredecesor, pilaDeAncestros);
            }
        }
        return valorARetornar;
    }
    private NodoMVias<K, V> buscarNodoDeLaClave(K claveAEliminar, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void prestarOFusionar(NodoMVias<K, V> nodoActual, Stack<NodoMVias<K, V>> pilaDeAncestros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private NodoMVias<K, V> buscarNodoDeClavePredecesora(Stack<NodoMVias<K, V>> pilaDeAncestros, NodoMVias<K, V> hijo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
