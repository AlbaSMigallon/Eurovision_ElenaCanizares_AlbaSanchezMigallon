package main;

import controlador.Controlador;

/**
 * Clase que contiene el metodo main, que es el punto de entrada principal de la aplicacion. En este caso, el metodo main
 * crea una instancia de la clase "Controlador" y llama al metodo "iniciarVista()" que ofrece una interfaz grafica
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 */
public class Main {
	/**
	 * Punto de entrada del programa
	 * @param args
	 */
	public static void main(String[] args) {
		new Controlador().iniciarVista();
	}
}
