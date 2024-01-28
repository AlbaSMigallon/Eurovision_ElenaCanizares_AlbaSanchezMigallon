package controlador;

import java.io.File;

public class LanzadorEurovision {
	public void lanzarServidor() {
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "controlador.Servidor");
			pb.directory(new File("bin"));
			pb.redirectOutput(new File("salidas/salidas_Servidor.txt"));
			pb.redirectError(new File("salidas/errores_Servidor.log"));
			pb.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void lanzaraplicacionEurovision() {
		try {
			ProcessBuilder pb = new ProcessBuilder("java", "vista.Vista");
			pb.directory(new File("bin"));
			pb.redirectOutput(new File("salidas/salidas_Eurovision.txt"));
			pb.redirectError(new File("salidas/errores_Eurovision.log"));
			pb.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LanzadorEurovision lanzador = new LanzadorEurovision();
			
			lanzador.lanzarServidor();
			lanzador.lanzaraplicacionEurovision();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
}
