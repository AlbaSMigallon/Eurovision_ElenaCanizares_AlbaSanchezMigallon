package persistencias;
// Generated 26 ene 2024 19:16:10 by Hibernate Tools 5.4.33.Final

/**
 * Cantantes generated by hbm2java
 */
public class Cantantes implements java.io.Serializable {

	private String pais;
	private String nombre;
	private String nombreCancion;

	public Cantantes() {
	}

	public Cantantes(String pais, String nombre) {
		this.pais = pais;
		this.nombre = nombre;
	}

	public Cantantes(String pais, String nombre, String nombreCancion) {
		this.pais = pais;
		this.nombre = nombre;
		this.nombreCancion = nombreCancion;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCancion() {
		return this.nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

}
