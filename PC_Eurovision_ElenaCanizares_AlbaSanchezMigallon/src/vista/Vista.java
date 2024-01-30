package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panelInicial, panelVotacionesNacionales, panelVotaciones, panelResultados, panelFinal;
	public JLabel lblFondoInicio, lblLogoInicio;
	public JLabel lblActuacionEspania, lblActuacionAlemania, lblActuacionFrancia, lblActuacionItalia,
			lblActuacionPortugal, lblActuacionReinoUnido, lblActuacionPolonia, lblActuacionPaisesBajos,
			lblActuacionRumania, lblActuacionGrecia;
	public JLabel lblTlfEspania, lblTlfAlemania, lblTlfFrancia, lblTlfItalia, lblTlfPortugal, lblTlfReinoUnido,
			lblTlfPolonia, lblTlfPaisesBajos, lblTlfRumania, lblTlfGrecia;
	public JLabel lblTaylorPaElena;
	public JButton btnComenzarInicio, btnComenzarVotaciones, btnRefrescarInfo;


	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// PANEL INICIAL
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 925, 606);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);

		btnComenzarInicio = new JButton("COMENZAR");
		btnComenzarInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarInicio.setBounds(369, 540, 181, 51);
		panelInicial.add(btnComenzarInicio);

		lblLogoInicio = new JLabel("");
		lblLogoInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoInicio.setBounds(0, 0, 925, 606);
		panelInicial.add(lblLogoInicio);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 925, 606);
		lblFondoInicio.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/fondo2.jpg"));
		panelInicial.add(lblFondoInicio);

		// PANEL VOTOS NACIONALES
		panelVotacionesNacionales = new JPanel();
		panelVotacionesNacionales.setBounds(0, 0, 925, 606);
		contentPane.add(panelVotacionesNacionales);
		panelVotacionesNacionales.setLayout(null);
		panelVotacionesNacionales.setVisible(false);

		// label de fotos actuaciones

		lblActuacionEspania = new JLabel("Actuacion Espania");
		lblActuacionEspania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionEspania.setBounds(22, 27, 196, 123);
		lblActuacionEspania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/1.gif"));
		panelVotacionesNacionales.add(lblActuacionEspania);

		lblActuacionAlemania = new JLabel("Actuacion Alemania");
		lblActuacionAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionAlemania.setBounds(249, 27, 196, 123);
		lblActuacionAlemania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/2.gif"));
		panelVotacionesNacionales.add(lblActuacionAlemania);

		lblActuacionFrancia = new JLabel("Actuacion Francia");
		lblActuacionFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionFrancia.setBounds(455, 27, 196, 123);
		lblActuacionFrancia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/3.gif"));
		panelVotacionesNacionales.add(lblActuacionFrancia);

		lblActuacionItalia = new JLabel("Actuacion Italia");
		lblActuacionItalia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionItalia.setBounds(668, 27, 196, 123);
		lblActuacionItalia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/4.gif"));
		panelVotacionesNacionales.add(lblActuacionItalia);

		lblActuacionPortugal = new JLabel("Actuacion Portugal");
		lblActuacionPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPortugal.setBounds(32, 185, 196, 123);
		lblActuacionPortugal.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/5.gif"));
		panelVotacionesNacionales.add(lblActuacionPortugal);

		lblActuacionReinoUnido = new JLabel("Actuacion ReinoUnido");
		lblActuacionReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionReinoUnido.setBounds(249, 185, 196, 123);
		lblActuacionReinoUnido.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/6.gif"));
		panelVotacionesNacionales.add(lblActuacionReinoUnido);

		lblActuacionPolonia = new JLabel("Actuacion Polonia");
		lblActuacionPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPolonia.setBounds(455, 185, 196, 123);
		lblActuacionPolonia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/7.gif"));
		panelVotacionesNacionales.add(lblActuacionPolonia);

		lblActuacionPaisesBajos = new JLabel("Actuacion Paises Bajos");
		lblActuacionPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPaisesBajos.setBounds(43, 342, 196, 123);
		lblActuacionPaisesBajos.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/8.gif"));
		panelVotacionesNacionales.add(lblActuacionPaisesBajos);

		lblActuacionRumania = new JLabel("Actuacion Rumania");
		lblActuacionRumania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionRumania.setBounds(249, 342, 196, 123);
		lblActuacionRumania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/9.gif"));
		panelVotacionesNacionales.add(lblActuacionRumania);

		lblActuacionGrecia = new JLabel("Actuacion Grecia");
		lblActuacionGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionGrecia.setBounds(455, 342, 196, 123);
		lblActuacionGrecia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/10.gif"));
		panelVotacionesNacionales.add(lblActuacionGrecia);

		// labels de tlf para votar
		lblTlfEspania = new JLabel("tlfno Espania");
		lblTlfEspania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfEspania.setBounds(81, 160, 89, 14);
		panelVotacionesNacionales.add(lblTlfEspania);

		lblTlfAlemania = new JLabel("tlfno Alemania");
		lblTlfAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfAlemania.setBounds(307, 160, 89, 14);
		panelVotacionesNacionales.add(lblTlfAlemania);

		lblTlfFrancia = new JLabel("tlfno Francia");
		lblTlfFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfFrancia.setBounds(510, 160, 89, 14);
		panelVotacionesNacionales.add(lblTlfFrancia);

		lblTlfItalia = new JLabel("tlfno Italia");
		lblTlfItalia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfItalia.setBounds(728, 160, 89, 14);
		panelVotacionesNacionales.add(lblTlfItalia);

		lblTlfPortugal = new JLabel("tlfno Portugal");
		lblTlfPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPortugal.setBounds(91, 318, 89, 14);
		panelVotacionesNacionales.add(lblTlfPortugal);

		lblTlfReinoUnido = new JLabel("tlfno ReinoUnido");
		lblTlfReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfReinoUnido.setBounds(307, 318, 109, 14);
		panelVotacionesNacionales.add(lblTlfReinoUnido);

		lblTlfPolonia = new JLabel("tlfno Polonia");
		lblTlfPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPolonia.setBounds(510, 318, 89, 14);
		panelVotacionesNacionales.add(lblTlfPolonia);

		lblTlfPaisesBajos = new JLabel("tlfno Paises Bajos");
		lblTlfPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPaisesBajos.setBounds(91, 475, 116, 14);
		panelVotacionesNacionales.add(lblTlfPaisesBajos);

		lblTlfRumania = new JLabel("tlfno Rumania");
		lblTlfRumania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfRumania.setBounds(307, 475, 89, 14);
		panelVotacionesNacionales.add(lblTlfRumania);

		lblTlfGrecia = new JLabel("tlfno Grecia");
		lblTlfGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfGrecia.setBounds(510, 475, 89, 14);
		panelVotacionesNacionales.add(lblTlfGrecia);

		btnComenzarVotaciones = new JButton("ESPERANDO");
		btnComenzarVotaciones.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarVotaciones.setBounds(389, 556, 155, 23);
		btnComenzarVotaciones.setEnabled(false);
		panelVotacionesNacionales.add(btnComenzarVotaciones);

		lblTaylorPaElena = new JLabel("");
		lblTaylorPaElena.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaylorPaElena.setBounds(623, 184, 302, 412);
		lblTaylorPaElena.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/taylor/taylor1.png"));
		panelVotacionesNacionales.add(lblTaylorPaElena);
		panelVotacionesNacionales.setLayout(null);

		panelVotaciones = new JPanel();
		panelVotaciones.setBounds(0, 0, 925, 606);
		contentPane.add(panelVotaciones);
		panelVotaciones.setLayout(null);

		btnRefrescarInfo = new JButton("New button");
		btnRefrescarInfo.setBounds(414, 554, 85, 21);
		panelVotaciones.add(btnRefrescarInfo);
		panelVotaciones.setVisible(false);


		// PANEL RESULTADOS FINALES EUROVISION
		/*panelResultados = new JPanel();
		panelResultados.setBounds(0, 0, 1500, 900);
		contentPane.add(panelResultados);
		panelResultados.setLayout(null);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1685, 910);
		lblFondoInicio.setIcon(new ImageIcon(
				"C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo2.jpg"));
		panelInicial.add(lblFondoInicio);

		// PANEL FINAL
		panelFinal = new JPanel();
		panelFinal.setBounds(0, 0, 1500, 900);
		contentPane.add(panelFinal);
		panelFinal.setLayout(null);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1500, 900);
		lblFondoInicio.setIcon(new ImageIcon(
				"C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo2.jpg"));
		panelInicial.add(lblFondoInicio);*/

	}

	public JPanel getPanelInicial() {
		return panelInicial;
	}

	public void setPanelInicial(JPanel panelInicial) {
		this.panelInicial = panelInicial;
	}

	public JPanel getPanelVotacionesNacionales() {
		return panelVotacionesNacionales;
	}

	public void setPanelVotacionesNacionales(JPanel panelVotacionesNacionales) {
		this.panelVotacionesNacionales = panelVotacionesNacionales;
	}






	public JPanel getPanelVotaciones() {
		return panelVotaciones;
	}

	public void setPanelVotaciones(JPanel panelVotaciones) {
		this.panelVotaciones = panelVotaciones;
	}

	public JButton getBtnComenzarVotaciones() {
		return btnComenzarVotaciones;
	}

	public void setBtnComenzarVotaciones(JButton btnComenzarVotaciones) {
		this.btnComenzarVotaciones = btnComenzarVotaciones;
	}

	public JLabel getLblLogoInicio() {
		return lblLogoInicio;
	}

	public void setLblLogoInicio(JLabel lblLogoInicio) {
		this.lblLogoInicio = lblLogoInicio;
	}
}
