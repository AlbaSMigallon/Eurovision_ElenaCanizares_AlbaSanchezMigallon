package persistencias;
// Generated 29 ene 2024 20:56:30 by Hibernate Tools 5.4.33.Final

/**
 * ResultadosFaseNacional generated by hbm2java
 */
public class ResultadosFaseNacional implements java.io.Serializable {

	private String pais;
	private String cantanteTercero;
	private String cantanteSegundo;
	private String cantantePrimero;

	public ResultadosFaseNacional() {
	}

	public ResultadosFaseNacional(String pais) {
		this.pais = pais;
	}

	public ResultadosFaseNacional(String pais, String cantanteTercero, String cantanteSegundo, String cantantePrimero) {
		this.pais = pais;
		this.cantanteTercero = cantanteTercero;
		this.cantanteSegundo = cantanteSegundo;
		this.cantantePrimero = cantantePrimero;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCantanteTercero() {
		return this.cantanteTercero;
	}

	public void setCantanteTercero(String cantanteTercero) {
		this.cantanteTercero = cantanteTercero;
	}

	public String getCantanteSegundo() {
		return this.cantanteSegundo;
	}

	public void setCantanteSegundo(String cantanteSegundo) {
		this.cantanteSegundo = cantanteSegundo;
	}

	public String getCantantePrimero() {
		return this.cantantePrimero;
	}

	public void setCantantePrimero(String cantantePrimero) {
		this.cantantePrimero = cantantePrimero;
	}

}
