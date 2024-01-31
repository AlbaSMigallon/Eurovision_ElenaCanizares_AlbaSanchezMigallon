package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panelInicial, panelVotacionesNacionales, panelVotaciones, panelResultados, panelFinal, panelAutoria;
	public JLabel lblFondoInicio, lblLogoInicio;
	public JLabel lblActuacionEspania, lblActuacionAlemania, lblActuacionFrancia, lblActuacionItalia,
			lblActuacionPortugal, lblActuacionReinoUnido, lblActuacionPolonia, lblActuacionPaisesBajos,
			lblActuacionRumania, lblActuacionGrecia, lblCabecera, lblLogoCentro;
	public JLabel lblTlfEspania, lblTlfAlemania, lblTlfFrancia, lblTlfItalia, lblTlfPortugal, lblTlfReinoUnido,
			lblTlfPolonia, lblTlfPaisesBajos, lblTlfRumania, lblTlfGrecia;
	public JLabel lblTaylorPaElena;
	public JButton btnComenzarInicio, btnComenzarVotaciones, btnRefrescarInfo, btnVolver;
	public JTextArea textAreaPrueba;
	public JMenuBar menuBar;
	public JMenu mnMenu;
    public JMenuItem itemMenuInformacion;
    public JLabel lblAutor1;
    public JLabel lblAutor2;
    public JLabel lblAutor3;
    public JPanel panelPaisesPuntos;
    public JLabel lblPosicion1;
    public JLabel lblPosicion2;
    public JLabel lblPosicion3;
    public JLabel lblPosicion4;
    public JLabel lblPosicion5;
    public JLabel lblPosicion6;
    public JLabel lblPosicion7;
    public JLabel lblPosicion8;
    public JLabel lblPosicion9;
    public JLabel lblPosicion10;


	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// PANEL INICIAL
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 925, 562);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);

		btnComenzarInicio = new JButton("COMENZAR");
		btnComenzarInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarInicio.setBounds(370, 501, 181, 51);
		panelInicial.add(btnComenzarInicio);

		lblLogoInicio = new JLabel("");
		lblLogoInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoInicio.setBounds(0, 0, 925, 577);
		panelInicial.add(lblLogoInicio);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 925, 562);
		lblFondoInicio.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/fondo2.jpg"));
		panelInicial.add(lblFondoInicio);

		// PANEL VOTOS NACIONALES
		panelVotacionesNacionales = new JPanel();
		panelVotacionesNacionales.setBounds(0, 0, 925, 562);
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
		btnComenzarVotaciones.setBounds(388, 529, 155, 23);
		btnComenzarVotaciones.setEnabled(false);
		panelVotacionesNacionales.add(btnComenzarVotaciones);

		lblTaylorPaElena = new JLabel("");
		lblTaylorPaElena.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaylorPaElena.setBounds(623, 184, 302, 368);
		lblTaylorPaElena.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/taylor/taylor1.png"));
		panelVotacionesNacionales.add(lblTaylorPaElena);
		panelVotacionesNacionales.setLayout(null);

		panelVotaciones = new JPanel();
		panelVotaciones.setBounds(0, 0, 925, 562);
		contentPane.add(panelVotaciones);
		panelVotaciones.setLayout(null);

		btnRefrescarInfo = new JButton("VOTACIONES");
		btnRefrescarInfo.setBounds(411, 516, 171, 36);
		panelVotaciones.add(btnRefrescarInfo);
		panelVotaciones.setVisible(false);

		textAreaPrueba = new JTextArea();
		textAreaPrueba.setBounds(256, 352, 496, 143);
		panelVotaciones.add(textAreaPrueba);

		panelPaisesPuntos = new JPanel();
		panelPaisesPuntos.setBounds(355, 62, 270, 266);
		panelVotaciones.add(panelPaisesPuntos);
		panelPaisesPuntos.setLayout(null);

		lblPosicion1 = new JLabel("1");
		lblPosicion1.setBounds(10, 25, 253, 13);
		panelPaisesPuntos.add(lblPosicion1);

		lblPosicion2 = new JLabel("2");
		lblPosicion2.setBounds(10, 49, 253, 13);
		panelPaisesPuntos.add(lblPosicion2);

		lblPosicion3 = new JLabel("3");
		lblPosicion3.setBounds(10, 72, 253, 13);
		panelPaisesPuntos.add(lblPosicion3);

		lblPosicion4 = new JLabel("4");
		lblPosicion4.setBounds(10, 95, 253, 13);
		panelPaisesPuntos.add(lblPosicion4);

		lblPosicion5 = new JLabel("5");
		lblPosicion5.setBounds(10, 118, 253, 13);
		panelPaisesPuntos.add(lblPosicion5);

		lblPosicion6 = new JLabel("6");
		lblPosicion6.setBounds(10, 144, 253, 13);
		panelPaisesPuntos.add(lblPosicion6);

		lblPosicion7 = new JLabel("7");
		lblPosicion7.setBounds(10, 167, 253, 13);
		panelPaisesPuntos.add(lblPosicion7);

		lblPosicion8 = new JLabel("8");
		lblPosicion8.setBounds(10, 190, 253, 13);
		panelPaisesPuntos.add(lblPosicion8);

		lblPosicion9 = new JLabel("9");
		lblPosicion9.setBounds(10, 213, 253, 13);
		panelPaisesPuntos.add(lblPosicion9);

		lblPosicion10 = new JLabel("10");
		lblPosicion10.setBounds(10, 236, 253, 13);
		panelPaisesPuntos.add(lblPosicion10);

		panelAutoria = new JPanel();
		panelAutoria.setBounds(0, 0, 925, 562);
		contentPane.add(panelAutoria);
		panelAutoria.setLayout(null);
		panelAutoria.setVisible(false);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(404, 524, 102, 28);
		panelAutoria.add(btnVolver);

		lblLogoCentro = new JLabel("");
		lblLogoCentro.setBounds(233, 253, 439, 236);
		panelAutoria.add(lblLogoCentro);
		lblLogoCentro.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/logos/logoEFA.jpg"));

		lblCabecera = new JLabel("2º DAM, EFA Moratalaz");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setBounds(179, 10, 530, 77);
		lblCabecera.setFont(new Font("Impact", Font.PLAIN, 30));
		panelAutoria.add(lblCabecera);

		lblAutor1 = new JLabel("Alba Sanchez-Migallón Calero");
		lblAutor1.setBounds(328, 97, 233, 28);
		panelAutoria.add(lblAutor1);
		lblAutor1.setFont(new Font("Impact", Font.PLAIN, 15));

		lblAutor2 = new JLabel("Elena Cañizares Jimenez");
		lblAutor2.setBounds(328, 146, 233, 28);
		panelAutoria.add(lblAutor2);
		lblAutor2.setFont(new Font("Impact", Font.PLAIN, 15));

		lblAutor3 = new JLabel("Carlos Guerrero Caro");
		lblAutor3.setBounds(328, 196, 233, 28);
		panelAutoria.add(lblAutor3);
		lblAutor3.setFont(new Font("Impact", Font.PLAIN, 15));



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

		menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        mnMenu = new JMenu("Menu");
    	menuBar.add(mnMenu);
    	itemMenuInformacion = new JMenuItem("Autoría");
		mnMenu.add(itemMenuInformacion);
		menuBar.setBounds(0, 0, getWidth(), 30);

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
