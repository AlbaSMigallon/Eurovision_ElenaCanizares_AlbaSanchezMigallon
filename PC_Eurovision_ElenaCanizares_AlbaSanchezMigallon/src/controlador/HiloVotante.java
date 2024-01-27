package controlador;

import java.util.Random;

public class HiloVotante extends Thread {
	/*
	 * Esta clase hilo se encarga de determinar el voto teniendo en cuenta la franja de edad y el filtro de no votar al pais de procedencia del voto
	 */
	private String voto;
	private String rangoEdad;
	private String pais;

	public HiloVotante(String pais, String rangoEdad) {
		this.rangoEdad = rangoEdad;
		this.pais = pais;

	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(String rangoEdad) {
		this.rangoEdad = rangoEdad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void run() {

		Random random = new Random();
		int randomNumber = random.nextInt(100) + 1;

		switch (this.getRangoEdad()) {
		case "1825":
			this.voto = obtenerResultado1825(randomNumber);
			break;
		case "2640":
			this.voto = obtenerResultado2640(randomNumber);
			break;
		case "4165":
			this.voto = obtenerResultado4165(randomNumber);
			break;
		case "66":
			this.voto = obtenerResultado66(randomNumber);
			break;

		}
	}

	private String obtenerResultado1825(int random) {

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado2640(int random) {

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado4165(int random) {

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

	private String obtenerResultado66(int random) {

		String resultado = "";

		do {
			if (random <= 7) {
				resultado = "Espania";
			}
			if (random >= 8 && random <= 10) {
				resultado = "Alemania";
			}
			if (random >= 11 && random <= 23) {
				resultado = "Francia";
			}
			if (random >= 24 && random <= 30) {
				resultado = "Italia";
			}
			if (random >= 31 && random <= 37) {
				resultado = "Portugal";
			}
			if (random >= 38 && random <= 51) {
				resultado = "Reino Unido";
			}
			if (random >= 52 && random <= 61) {
				resultado = "Polonia";
			}
			if (random >= 62 && random <= 88) {
				resultado = "Paises Bajos";
			}
			if (random >= 89 && random <= 95) {
				resultado = "Rumania";
			}
			if (random >= 96 && random <= 100) {
				resultado = "Grecia";
			}
		} while (resultado.equals(this.getPais()));

		return resultado;

	}

}
