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

/**
 * Clase que extiende JFrame para crear una ventana grafica
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos Guerrero Caro
 * @version 1.0
 * @see JFrame
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	// JPanel
	public JPanel contentPane, panelInicial, panelVotacionesNacionales, panelVotaciones, panelResultados, panelAutoria,
				  panelBanderas, panelFinal, panelPaisesPuntos;
	// JLabel
	public JLabel lblActuacionEspania, lblActuacionAlemania, lblActuacionFrancia, lblActuacionItalia,
				  lblActuacionPortugal, lblActuacionReinoUnido, lblActuacionPolonia, lblActuacionPaisesBajos,
				  lblActuacionRumania, lblActuacionGrecia, lblCabecera, lblLogoCentro, lblNombreGanador, lblCancionGanador,
				  lblFondoInicio, lblLogoInicio, lblTlfEspania, lblTlfAlemania, lblTlfFrancia, lblTlfItalia, lblTlfPortugal,
				  lblTlfReinoUnido, lblTlfPolonia, lblTlfPaisesBajos, lblTlfRumania, lblTlfGrecia, lblActuacionGanador,
				  lblTaylorPaElena, lblAutor1, lblAutor2, lblAutor3, lblPosicion1, lblPosicion2, lblPosicion3, lblPosicion4,
				  lblPosicion5, lblPosicion6, lblPosicion7, lblPosicion8, lblPosicion9, lblPosicion10, lblPaisGanador,
				  lblBandera1, lblBandera2, lblBandera3, lblBandera4, lblBandera5, lblBandera6, lblBandera7, lblBandera8,
				  lblBandera9, lblBandera10;
	// JButton
	public JButton btnComenzarInicio, btnComenzarVotaciones, btnRefrescarInfo, btnVolver;
	// JTextArea
	public JTextArea textAreaPrueba;
	// JMenuBar
	public JMenuBar menuBar;
	// JMenu
	public JMenu mnMenu;
	// JMenuItem
    public JMenuItem itemMenuInformacion;

    /**
	 * Constructor de la clase "Vista".
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 621);

		// JPanel "contentPane" que contiene todos los elementos
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// JPanel "panelInicial"
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 925, 562);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);

		// Elementos del JPanel "panelInicial"
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

		// JPanel "panelVotosNacionales"
		panelVotacionesNacionales = new JPanel();
		panelVotacionesNacionales.setBounds(0, 0, 925, 562);
		contentPane.add(panelVotacionesNacionales);
		panelVotacionesNacionales.setLayout(null);
		panelVotacionesNacionales.setVisible(false);

		// Elementos del JPanel "panelVotacionesNacionales"
		// JLabels de las actuaciones de los distintos paises
		lblActuacionEspania = new JLabel("Actuacion Espania");
		lblActuacionEspania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionEspania.setBounds(22, 27, 196, 123);
		lblActuacionEspania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Espania.gif"));
		panelVotacionesNacionales.add(lblActuacionEspania);

		lblActuacionAlemania = new JLabel("Actuacion Alemania");
		lblActuacionAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionAlemania.setBounds(249, 27, 196, 123);
		lblActuacionAlemania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Alemania.gif"));
		panelVotacionesNacionales.add(lblActuacionAlemania);

		lblActuacionFrancia = new JLabel("Actuacion Francia");
		lblActuacionFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionFrancia.setBounds(455, 27, 196, 123);
		lblActuacionFrancia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Francia.gif"));
		panelVotacionesNacionales.add(lblActuacionFrancia);

		lblActuacionItalia = new JLabel("Actuacion Italia");
		lblActuacionItalia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionItalia.setBounds(668, 27, 196, 123);
		lblActuacionItalia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Italia.gif"));
		panelVotacionesNacionales.add(lblActuacionItalia);

		lblActuacionPortugal = new JLabel("Actuacion Portugal");
		lblActuacionPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPortugal.setBounds(32, 185, 196, 123);
		lblActuacionPortugal.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Portugal.gif"));
		panelVotacionesNacionales.add(lblActuacionPortugal);

		lblActuacionReinoUnido = new JLabel("Actuacion ReinoUnido");
		lblActuacionReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionReinoUnido.setBounds(249, 185, 196, 123);
		lblActuacionReinoUnido.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/ReinoUnido.gif"));
		panelVotacionesNacionales.add(lblActuacionReinoUnido);

		lblActuacionPolonia = new JLabel("Actuacion Polonia");
		lblActuacionPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPolonia.setBounds(455, 185, 196, 123);
		lblActuacionPolonia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Polonia.gif"));
		panelVotacionesNacionales.add(lblActuacionPolonia);

		lblActuacionPaisesBajos = new JLabel("Actuacion Paises Bajos");
		lblActuacionPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionPaisesBajos.setBounds(43, 342, 196, 123);
		lblActuacionPaisesBajos.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/PaisesBajos.gif"));
		panelVotacionesNacionales.add(lblActuacionPaisesBajos);

		lblActuacionRumania = new JLabel("Actuacion Rumania");
		lblActuacionRumania.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionRumania.setBounds(249, 342, 196, 123);
		lblActuacionRumania.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Rumania.gif"));
		panelVotacionesNacionales.add(lblActuacionRumania);

		lblActuacionGrecia = new JLabel("Actuacion Grecia");
		lblActuacionGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionGrecia.setBounds(455, 342, 196, 123);
		lblActuacionGrecia.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/Grecia.gif"));
		panelVotacionesNacionales.add(lblActuacionGrecia);

		// JLabels de tlf para votar
		lblTlfEspania = new JLabel("tlfno Espania: 678-987-543");
		lblTlfEspania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfEspania.setBounds(43, 160, 159, 14);
		panelVotacionesNacionales.add(lblTlfEspania);

		lblTlfAlemania = new JLabel("tlfno Alemania: 765-345-789");
		lblTlfAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfAlemania.setBounds(259, 160, 159, 14);
		panelVotacionesNacionales.add(lblTlfAlemania);

		lblTlfFrancia = new JLabel("tlfno Francia: 879-654-321");
		lblTlfFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfFrancia.setBounds(476, 160, 159, 14);
		panelVotacionesNacionales.add(lblTlfFrancia);

		lblTlfItalia = new JLabel("tlfno Italia: 876-543-212");
		lblTlfItalia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfItalia.setBounds(688, 160, 159, 14);
		panelVotacionesNacionales.add(lblTlfItalia);

		lblTlfPortugal = new JLabel("tlfno Portugal: 789-876-654");
		lblTlfPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPortugal.setBounds(54, 318, 159, 14);
		panelVotacionesNacionales.add(lblTlfPortugal);

		lblTlfReinoUnido = new JLabel("tlfno ReinoUnido: 897-765-789");
		lblTlfReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfReinoUnido.setBounds(259, 318, 176, 14);
		panelVotacionesNacionales.add(lblTlfReinoUnido);

		lblTlfPolonia = new JLabel("tlfno Polonia: 987-987-567");
		lblTlfPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPolonia.setBounds(476, 318, 159, 14);
		panelVotacionesNacionales.add(lblTlfPolonia);

		lblTlfPaisesBajos = new JLabel("tlfno Paises Bajos: 897-543-654");
		lblTlfPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfPaisesBajos.setBounds(53, 475, 176, 14);
		panelVotacionesNacionales.add(lblTlfPaisesBajos);

		lblTlfRumania = new JLabel("tlfno Rumania: 987-456-876");
		lblTlfRumania.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfRumania.setBounds(272, 475, 159, 14);
		panelVotacionesNacionales.add(lblTlfRumania);

		lblTlfGrecia = new JLabel("tlfno Grecia: 768-654-123");
		lblTlfGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTlfGrecia.setBounds(476, 475, 159, 14);
		panelVotacionesNacionales.add(lblTlfGrecia);

		btnComenzarVotaciones = new JButton("ESPERANDO");
		btnComenzarVotaciones.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarVotaciones.setBounds(307, 519, 272, 33);
		btnComenzarVotaciones.setEnabled(false);
		panelVotacionesNacionales.add(btnComenzarVotaciones);

		lblTaylorPaElena = new JLabel("");
		lblTaylorPaElena.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaylorPaElena.setBounds(623, 184, 302, 368);
		lblTaylorPaElena.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/taylor/taylor1.png"));
		panelVotacionesNacionales.add(lblTaylorPaElena);
		panelVotacionesNacionales.setLayout(null);

		// JPanel "panelVotaciones"
		panelVotaciones = new JPanel();
		panelVotaciones.setBounds(0, 0, 925, 562);
		contentPane.add(panelVotaciones);
		panelVotaciones.setLayout(null);

		// Elementos del JPanel "panelVotaciones"
		btnRefrescarInfo = new JButton("VOTACIONES");
		btnRefrescarInfo.setBounds(411, 516, 214, 36);
		panelVotaciones.add(btnRefrescarInfo);
		panelVotaciones.setVisible(false);

		textAreaPrueba = new JTextArea();
		textAreaPrueba.setBounds(253, 415, 496, 99);
		panelVotaciones.add(textAreaPrueba);

		// JPanel "panelPaisesPuntos"
		panelPaisesPuntos = new JPanel();
		panelPaisesPuntos.setBounds(355, 25, 270, 380);
		panelVotaciones.add(panelPaisesPuntos);
		panelPaisesPuntos.setLayout(null);
		panelPaisesPuntos.setVisible(false);

		// Elementos del JPanel "panelPaisesPuntos"
		lblPosicion1 = new JLabel("1");
		lblPosicion1.setBounds(10, 10, 253, 19);
		panelPaisesPuntos.add(lblPosicion1);

		lblPosicion2 = new JLabel("2");
		lblPosicion2.setBounds(10, 42, 253, 19);
		panelPaisesPuntos.add(lblPosicion2);

		lblPosicion3 = new JLabel("3");
		lblPosicion3.setBounds(10, 71, 253, 21);
		panelPaisesPuntos.add(lblPosicion3);

		lblPosicion4 = new JLabel("4");
		lblPosicion4.setBounds(10, 102, 253, 19);
		panelPaisesPuntos.add(lblPosicion4);

		lblPosicion5 = new JLabel("5");
		lblPosicion5.setBounds(10, 131, 253, 19);
		panelPaisesPuntos.add(lblPosicion5);

		lblPosicion6 = new JLabel("6");
		lblPosicion6.setBounds(10, 164, 253, 19);
		panelPaisesPuntos.add(lblPosicion6);

		lblPosicion7 = new JLabel("7");
		lblPosicion7.setBounds(10, 193, 253, 19);
		panelPaisesPuntos.add(lblPosicion7);

		lblPosicion8 = new JLabel("8");
		lblPosicion8.setBounds(10, 227, 253, 19);
		panelPaisesPuntos.add(lblPosicion8);

		lblPosicion9 = new JLabel("9");
		lblPosicion9.setBounds(10, 266, 253, 19);
		panelPaisesPuntos.add(lblPosicion9);

		lblPosicion10 = new JLabel("10");
		lblPosicion10.setBounds(10, 305, 253, 19);
		panelPaisesPuntos.add(lblPosicion10);

		// JPanel "panelBanderas"
		panelBanderas = new JPanel();
		panelBanderas.setBounds(253, 25, 67, 389);
		panelVotaciones.add(panelBanderas);
		panelBanderas.setLayout(null);
		panelBanderas.setVisible(false);

		// Elementos del JPanel "panelBanderas"
		lblBandera1 = new JLabel("Bandera1");
		lblBandera1.setBounds(0, 10, 67, 20);
		panelBanderas.add(lblBandera1);

		lblBandera2 = new JLabel("Bandera2");
		lblBandera2.setBounds(0, 40, 67, 20);
		panelBanderas.add(lblBandera2);

		lblBandera3 = new JLabel("Bandera3");
		lblBandera3.setBounds(0, 70, 67, 20);
		panelBanderas.add(lblBandera3);

		lblBandera4 = new JLabel("Bandera4");
		lblBandera4.setBounds(0, 100, 67, 20);
		panelBanderas.add(lblBandera4);

		lblBandera5 = new JLabel("Bandera5");
		lblBandera5.setBounds(0, 132, 67, 20);
		panelBanderas.add(lblBandera5);

		lblBandera6 = new JLabel("Bandera6");
		lblBandera6.setBounds(0, 162, 67, 20);
		panelBanderas.add(lblBandera6);

		lblBandera7 = new JLabel("Bandera7");
		lblBandera7.setBounds(0, 192, 67, 20);
		panelBanderas.add(lblBandera7);

		lblBandera8 = new JLabel("Bandera8");
		lblBandera8.setBounds(0, 228, 67, 20);
		panelBanderas.add(lblBandera8);

		lblBandera9 = new JLabel("Bandera9");
		lblBandera9.setBounds(0, 265, 67, 20);
		panelBanderas.add(lblBandera9);

		lblBandera10 = new JLabel("Bandera10");
		lblBandera10.setBounds(0, 304, 67, 20);
		panelBanderas.add(lblBandera10);

		// JPanel "panelAutoria"
		panelAutoria = new JPanel();
		panelAutoria.setBounds(0, 0, 925, 562);
		contentPane.add(panelAutoria);
		panelAutoria.setLayout(null);
		panelAutoria.setVisible(false);

		// Elementos del JPanel "panelAutoria"
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(404, 524, 102, 28);
		panelAutoria.add(btnVolver);

		lblLogoCentro = new JLabel("");
		lblLogoCentro.setBounds(233, 253, 439, 236);
		lblLogoCentro.setIcon(new ImageIcon(System.getProperty("user.dir")+"/resources/logos/logoEFA.jpg"));
		panelAutoria.add(lblLogoCentro);

		lblCabecera = new JLabel("2º DAM, EFA Moratalaz");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setBounds(179, 10, 530, 77);
		lblCabecera.setFont(new Font("Impact", Font.PLAIN, 30));
		panelAutoria.add(lblCabecera);

		lblAutor1 = new JLabel("Alba Sanchez-Migallón Calero");
		lblAutor1.setBounds(328, 97, 233, 28);
		lblAutor1.setFont(new Font("Impact", Font.PLAIN, 15));
		panelAutoria.add(lblAutor1);

		lblAutor2 = new JLabel("Elena Cañizares Jimenez");
		lblAutor2.setBounds(328, 146, 233, 28);
		lblAutor2.setFont(new Font("Impact", Font.PLAIN, 15));
		panelAutoria.add(lblAutor2);

		lblAutor3 = new JLabel("Carlos Guerrero Caro");
		lblAutor3.setBounds(328, 196, 233, 28);
		lblAutor3.setFont(new Font("Impact", Font.PLAIN, 15));
		panelAutoria.add(lblAutor3);

		// JPanel "panelFinal"
		panelFinal = new JPanel();
		panelFinal.setBounds(0, 0, 925, 562);
		contentPane.add(panelFinal);
		panelFinal.setLayout(null);

		// Elementos del JPanel "panelFinal"
		lblActuacionGanador = new JLabel("");
		lblActuacionGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionGanador.setBounds(312, 97, 356, 277);
		panelFinal.add(lblActuacionGanador);

		lblNombreGanador = new JLabel("");
		lblNombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreGanador.setBounds(372, 380, 246, 43);
		lblNombreGanador.setFont(new Font("Impact", Font.PLAIN, 30));
		panelFinal.add(lblNombreGanador);

		lblCancionGanador = new JLabel("");
		lblCancionGanador.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
		lblCancionGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancionGanador.setBounds(353, 433, 282, 43);
		panelFinal.add(lblCancionGanador);

		lblPaisGanador = new JLabel("");
		lblPaisGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisGanador.setFont(new Font("Impact", Font.PLAIN, 40));
		lblPaisGanador.setBounds(312, 10, 356, 85);
		panelFinal.add(lblPaisGanador);
		panelFinal.setVisible(false);

		// JMenuBar "menuBar" con sus respectivos JMenu "mnMenu" y JItemMenu "itemMenuInformacion"
		menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        mnMenu = new JMenu("Menu");
    	menuBar.add(mnMenu);
    	itemMenuInformacion = new JMenuItem("Autoría");
		mnMenu.add(itemMenuInformacion);
		menuBar.setBounds(0, 0, getWidth(), 30);
	}

	// Getters requeridos dentro del Timer del controlador, pese a que son elementos declarados como publicos
	public JPanel getPanelInicial() {
		return panelInicial;
	}
	public JPanel getPanelVotacionesNacionales() {
		return panelVotacionesNacionales;
	}
	public JPanel getPanelVotaciones() {
		return panelVotaciones;
	}
	public JButton getBtnComenzarVotaciones() {
		return btnComenzarVotaciones;
	}
	public JLabel getLblLogoInicio() {
		return lblLogoInicio;
	}
}
