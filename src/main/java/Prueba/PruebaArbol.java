/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import com.mycompany.practico1moiragenesislozano.AVL;
import com.mycompany.practico1moiragenesislozano.ArbolB;
import com.mycompany.practico1moiragenesislozano.ArbolBinarioBusqueda;
import com.mycompany.practico1moiragenesislozano.ArbolMViasBusqueda;
import com.mycompany.practico1moiragenesislozano.IArbolBusqueda;
import com.mycompany.practico1moiragenesislozano.IArbolMVias;
import com.mycompany.practico1moiragenesislozano.NodoBinario;
import practico1.excepciones.ExcepcionClaveNoExiste;
import practico1.excepciones.ExcepcionOrdenInvalido;

/**
 *
 * @author Moira
 */
public class PruebaArbol {
  public static void main(String argumentos[]) throws ExcepcionClaveNoExiste, ExcepcionOrdenInvalido {
        IArbolBusqueda<Integer, String> arbolBinario;
        IArbolBusqueda<Integer, String> arbolAVL;
        IArbolMVias<Integer, String> arbolMVias; 
        IArbolMVias<Integer,String> arbolB;
        System.out.println("***Arbol Binario Busqueda***");
        arbolBinario = new ArbolBinarioBusqueda<>();          
        arbolBinario.insertar(50, "Franco");
        arbolBinario.insertar(60, "Abner");
        arbolBinario.insertar(70, "Yuliana");
        arbolBinario.insertar(90, "Jorge");
        arbolBinario.insertar(40, "Marco");
        arbolBinario.insertar(20, "Ruth");
        arbolBinario.insertar(65, "Ricky");
        arbolBinario.insertar(68, "Harold");
        arbolBinario.insertar(110, "Andrea");
        System.out.println(arbolBinario);
        
        ArbolBinarioBusqueda<Integer, String> arbolBinario2 = new ArbolBinarioBusqueda<>();          
        arbolBinario2.insertar(50, "Franco");
        arbolBinario2.insertar(60, "Abner");
        arbolBinario2.insertar(70, "Yuliana");
        arbolBinario2.insertar(90, "Jorge");
        arbolBinario2.insertar(40, "Marco");
        arbolBinario2.insertar(20, "Ruth");
        arbolBinario2.insertar(65, "Ricky");
        arbolBinario2.insertar(68, "Harold");
        arbolBinario2.insertar(110, "Andrea");
        System.out.println("--------------PRACTICO 1--------------");
        
        arbolMVias = new ArbolMViasBusqueda<>(4);
        arbolMVias.insertar(50, "Franco");
        arbolMVias.insertar(60, "Abner");
        arbolMVias.insertar(70, "Yuliana");
        arbolMVias.insertar(90, "Jorge");
        arbolMVias.insertar(40, "Marco");
        arbolMVias.insertar(20, "Ruth");
        arbolMVias.insertar(65, "Ricky");
        arbolMVias.insertar(68, "Harold");
        arbolMVias.insertar(110, "Andrea");
        System.out.println(arbolMVias); 
        System.out.println("2. Para un árbol binario de búsqueda \n "
                + "implementar el recorrido en post orden ITERATIVO: "
                + arbolBinario.recorridoEnPostOrden());
        System.out.println("3.Para un árbol MVias implementar recorrido en PostOrden" +arbolMVias.recorridoEnPostOrden());
         
        System.out.println("4.Para un árbol MVias implementar recorrido en PretOrden" +arbolMVias.recorridoEnPreOrden());  
        
        System.out.println("5.Para un árbol MVias implementar recorrido en InOrden" +arbolMVias.recorridoEnInOrden());
        
        arbolAVL = new AVL<>();
        arbolAVL.insertar(50, "Franco");
        arbolAVL.insertar(60, "Abner");
        arbolAVL.insertar(70, "Yuliana");
        arbolAVL.insertar(90, "Jorge");
        arbolAVL.insertar(40, "Marco");
        arbolAVL.insertar(20, "Ruth");
        arbolAVL.insertar(65, "Ricky");
        arbolAVL.insertar(68, "Harold");
        arbolAVL.insertar(110, "Andrea");
        System.out.println(arbolAVL);
        
        System.out.println("6.Para el árbol AVL implemente el método eliminar: ");
        arbolMVias.insertar(32, "Ana");
        System.out.println(arbolMVias);        
        
        System.out.println("7.Para el árbol AVL implemente el método eliminar: ");
        arbolAVL.eliminar(70);
        System.out.println(arbolAVL);
        
        arbolB = new ArbolB<>(4);
        arbolB.insertar(300, "Franco");
        arbolB.insertar(500, "Abner");
        arbolB.insertar(100, "Yuliana");
        arbolB.insertar(50, "Jorge");
        arbolB.insertar(400, "Marco");
        arbolB.insertar(800, "Ruth");
        arbolB.insertar(90, "Ricky");
        arbolB.insertar(91, "Harold");
        arbolB.insertar(70, "Andrea");
        arbolB.insertar(75, "Andrea");
        arbolB.insertar(99, "Andrea");
        System.out.println(arbolB);
        System.out.println("8.Para el árbol B implemente el método insertar: ");
        arbolB.insertar(10, "Ana");
        System.out.println(arbolB); 
        
        System.out.println("10.Implemente el método eliminar de un árbol m-vias de búsqueda: ");
        arbolMVias.insertar(32, "Ana");
        System.out.println(arbolMVias); 
        
        System.out.println("11.Implemente el método eliminar de un árbol m-vias de búsqueda: ");
        arbolMVias.eliminar(40);
        System.out.println(arbolMVias);
        
        System.out.println("12. método RECURSIVO que retorne la cantidad de nodos que tienen un \n" +
                 "solo hijo no vacío. La solución debe usar un recorrido post orden : "
                + arbolBinario.cantidadNodosUnSoloHijoNoVacio());
                
        System.out.println("13. Cantidad de Hijos Vacíos usando recorrido InOrden: " + arbolBinario.cantidadHijosVacíosInOrden());
                NodoBinario<Integer,String> nodoABuscar = new NodoBinario<>(110,"Ruth");
        System.out.println("14. Implemente un método privado que reciba un nodo binario de un \n" +
                                   " árbol binario y que retorne cuál sería su predecesor inorden \n" +
                                   " de la clave de dicho nodo: " 
                + arbolBinario.predecedorInOrden(nodoABuscar));
        ArbolMViasBusqueda<Integer,String> arbolCopia = new ArbolMViasBusqueda<>(4);
        arbolCopia.insertar(50, "Franco");
        arbolCopia.insertar(60, "Abner");        
        arbolCopia.insertar(70, "Yuliana");
        arbolCopia.insertar(90, "Jorge");
        arbolCopia.insertar(40, "Marco");
        arbolCopia.insertar(45, "jUAN");
        arbolCopia.insertar(20, "Ruth");
        arbolCopia.insertar(65, "Ricky");  
 
        System.out.println("17. Para un árbol m vías implementar un método que reciba otro \n"
                + "árbol de parámetro y que retorne verdadero si los arboles son \n"
                + "similares. Falso en caso contrario: "
                + arbolMVias.sonIguales(arbolCopia)); 
                
        System.out.println("18. Para un árbol binario de búsqueda implemente un método que reciba como parámetro otro \n" +
         "árbol y que retorne verdadero si los árboles son similares, falso en caso contrario: "
                +arbolBinario.verificarSiSonArbolesSimilares(arbolBinario2));
                        

     
        
  }
}
