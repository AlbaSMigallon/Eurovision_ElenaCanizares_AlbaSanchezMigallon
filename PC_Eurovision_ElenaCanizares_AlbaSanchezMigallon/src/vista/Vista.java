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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LinearGradientPaint;
import java.awt.image.ImageObserver;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

/**
 * Clase que extiende JFrame para crear una ventana grafica
 * 
 * @author Alba Sanchez-Migallon Arias, Elena Cañizares Jimenez y Carlos
 *         Guerrero Caro
 * @version 1.0
 * @see JFrame
 */
public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	// JPanel
	public JPanel contentPane, panelInicial, panelVotacionesNacionales, panelVotaciones, panelResultados, panelAutoria,
			panelBanderas, panelFinal, panelPaisesPuntos, panelTf;
	// JLabel
	public JLabel lblActuacionEspania, lblActuacionAlemania, lblActuacionFrancia, lblActuacionItalia,
			lblActuacionPortugal, lblActuacionReinoUnido, lblActuacionPolonia, lblActuacionPaisesBajos,
			lblActuacionRumania, lblActuacionGrecia, lblCabecera, lblLogoCentro, lblNombreGanador, lblCancionGanador,
			lblFondoInicio, lblLogoInicio, lblTlfEspania, lblTlfAlemania, lblTlfFrancia, lblTlfItalia, lblTlfPortugal,
			lblTlfReinoUnido, lblTlfPolonia, lblTlfPaisesBajos, lblTlfRumania, lblTlfGrecia, lblActuacionGanador,
			lblTaylorPaElena, lblAutor1, lblAutor2, lblAutor3, lblPosicion1, lblPosicion2, lblPosicion3, lblPosicion4,
			lblPosicion5, lblPosicion6, lblPosicion7, lblPosicion8, lblPosicion9, lblPosicion10, lblPaisGanador,
			lblBandera1, lblBandera2, lblBandera3, lblBandera4, lblBandera5, lblBandera6, lblBandera7, lblBandera8,
			lblBandera9, lblBandera10, lblCarrusel, lblFondoTaylor, lblImagenPresentador, lblFondoPanelVotaciones,
			lblApano, lblApano2, lblApano3, lblApano4, lblApano5, lblApano6, lblApano7, lblApano8, lblApano9,
			lblFondoAutoria, lblApano10, lblFondoFinal, lblPaisActual, lblPaisConsultaVotaciones1,
			lblPaisConsultaVotaciones2, lblPaisConsultaVotaciones3, lbl15, lbl10, lbl8;
	// JButton
	public JButton btnComenzarInicio, btnComenzarVotaciones, btnRefrescarInfo, btnVolver, btnCarruselAnterior,
			btnCarruselSiguiente;
	// JTextArea
	public JTextArea textAreaPrueba;
	// JMenuBar
	public JMenuBar menuBar;
	// JMenu
	public JMenu mnMenu;
	// JMenuItem
	public JMenuItem itemMenuInformacion;

	public ImageIcon imagenCarrusel;
	/**
	 * Constructor de la clase "Vista".
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 900);

		// JPanel "contentPane" que contiene todos los elementos
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// JPanel "panelVotaciones"
		panelVotaciones = new JPanel();
		panelVotaciones.setBounds(0, 0, 1400, 900);

		contentPane.add(panelVotaciones);
		panelVotaciones.setLayout(null);

		// Elementos del JPanel "panelVotaciones"
		btnRefrescarInfo = new JButton("VOTACIONES");
		btnRefrescarInfo.setBounds(578, 751, 214, 36);
		panelVotaciones.add(btnRefrescarInfo);
		panelVotaciones.setVisible(false);

		textAreaPrueba = new JTextArea();
		textAreaPrueba.setBounds(275, 622, 496, 99);
		textAreaPrueba.setVisible(false);
		panelVotaciones.add(textAreaPrueba);

		// JPanel "panelPaisesPuntos"
		panelPaisesPuntos = new JPanel();
		panelPaisesPuntos.setBounds(132, 175, 265, 407);
		panelVotaciones.add(panelPaisesPuntos);
		panelPaisesPuntos.setLayout(null);
		panelPaisesPuntos.setOpaque(false);
		panelPaisesPuntos.setVisible(false);

		// Elementos del JPanel "panelPaisesPuntos"
		lblPosicion1 = new JLabel("1");
		lblPosicion1.setBounds(10, 10, 253, 28);
		lblPosicion1.setOpaque(true);
		lblPosicion1.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion1);

		lblPosicion2 = new JLabel("2");
		lblPosicion2.setBounds(10, 50, 253, 28);
		lblPosicion2.setOpaque(true);
		lblPosicion2.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion2);

		lblPosicion3 = new JLabel("3");
		lblPosicion3.setBounds(10, 90, 253, 28);
		lblPosicion3.setOpaque(true);
		lblPosicion3.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion3);

		lblPosicion4 = new JLabel("4");
		lblPosicion4.setBounds(10, 130, 253, 28);
		lblPosicion4.setOpaque(true);
		lblPosicion4.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion4);

		lblPosicion5 = new JLabel("5");
		lblPosicion5.setBounds(10, 170, 253, 28);
		lblPosicion5.setOpaque(true);
		lblPosicion5.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion5);

		lblPosicion6 = new JLabel("6");
		lblPosicion6.setBounds(10, 210, 253, 28);
		lblPosicion6.setOpaque(true);
		lblPosicion6.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion6);

		lblPosicion7 = new JLabel("7");
		lblPosicion7.setBounds(10, 250, 253, 28);
		lblPosicion7.setOpaque(true);
		lblPosicion7.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion7);

		lblPosicion8 = new JLabel("8");
		lblPosicion8.setBounds(10, 290, 253, 28);
		lblPosicion8.setOpaque(true);
		lblPosicion8.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion8);

		lblPosicion9 = new JLabel("9");
		lblPosicion9.setBounds(10, 330, 253, 28);
		lblPosicion9.setOpaque(true);
		lblPosicion9.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion9);

		lblPosicion10 = new JLabel("10");
		lblPosicion10.setBounds(10, 370, 253, 28);
		lblPosicion10.setOpaque(true);
		lblPosicion10.setBackground(Color.WHITE);
		panelPaisesPuntos.add(lblPosicion10);

		// JPanel "panelBanderas"
		panelBanderas = new JPanel();
		panelBanderas.setBounds(65, 175, 67, 407);
		panelVotaciones.add(panelBanderas);
		panelBanderas.setLayout(null);
		panelBanderas.setOpaque(false);
		panelBanderas.setVisible(false);

		// Elementos del JPanel "panelBanderas"
		lblBandera1 = new JLabel("Bandera1");
		lblBandera1.setBounds(0, 10, 46, 29);
		panelBanderas.add(lblBandera1);

		lblBandera2 = new JLabel("Bandera2");
		lblBandera2.setBounds(0, 50, 46, 29);
		panelBanderas.add(lblBandera2);

		lblBandera3 = new JLabel("Bandera3");
		lblBandera3.setBounds(0, 90, 46, 29);
		panelBanderas.add(lblBandera3);

		lblBandera4 = new JLabel("Bandera4");
		lblBandera4.setBounds(0, 130, 46, 29);
		panelBanderas.add(lblBandera4);

		lblBandera5 = new JLabel("Bandera5");
		lblBandera5.setBounds(0, 170, 46, 29);
		panelBanderas.add(lblBandera5);

		lblBandera6 = new JLabel("Bandera6");
		lblBandera6.setBounds(0, 210, 46, 29);
		panelBanderas.add(lblBandera6);

		lblBandera7 = new JLabel("Bandera7");
		lblBandera7.setBounds(0, 250, 46, 29);
		panelBanderas.add(lblBandera7);

		lblBandera8 = new JLabel("Bandera8");
		lblBandera8.setBounds(0, 290, 46, 29);
		panelBanderas.add(lblBandera8);

		lblBandera9 = new JLabel("Bandera9");
		lblBandera9.setBounds(0, 330, 46, 29);
		panelBanderas.add(lblBandera9);

		lblBandera10 = new JLabel("Bandera10");
		lblBandera10.setBounds(0, 370, 46, 29);
		panelBanderas.add(lblBandera10);

		lblImagenPresentador = new JLabel("");
		lblImagenPresentador.setBounds(485, 0, 850, 599);
		lblImagenPresentador.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPresentador.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/taylor/taylor3.png"));
		panelVotaciones.add(lblImagenPresentador);
		panelVotaciones.setLayout(null);

		lblApano = new JLabel("1");
		lblApano.setBounds(394, 185, 46, 28);
		lblApano.setBackground(new Color(255, 0, 128));
		lblApano.setForeground(Color.WHITE);
		lblApano.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano.setVerticalAlignment(SwingConstants.CENTER);
		lblApano.setOpaque(true);
		lblApano.setVisible(false);
		panelVotaciones.add(lblApano);

		lblApano2 = new JLabel("2");
		lblApano2.setVerticalAlignment(SwingConstants.CENTER);
		lblApano2.setOpaque(true);
		lblApano2.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano2.setForeground(Color.WHITE);
		lblApano2.setBackground(new Color(255, 0, 128));
		lblApano2.setBounds(394, 226, 46, 28);
		lblApano2.setVisible(false);
		panelVotaciones.add(lblApano2);

		lblApano3 = new JLabel("3");
		lblApano3.setVerticalAlignment(SwingConstants.CENTER);
		lblApano3.setOpaque(true);
		lblApano3.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano3.setForeground(Color.WHITE);
		lblApano3.setBackground(new Color(255, 0, 128));
		lblApano3.setBounds(394, 265, 46, 28);
		lblApano3.setVisible(false);
		panelVotaciones.add(lblApano3);

		lblApano4 = new JLabel("4");
		lblApano4.setVerticalAlignment(SwingConstants.CENTER);
		lblApano4.setOpaque(true);
		lblApano4.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano4.setForeground(Color.WHITE);
		lblApano4.setBackground(new Color(255, 0, 128));
		lblApano4.setBounds(394, 306, 46, 28);
		lblApano4.setVisible(false);
		panelVotaciones.add(lblApano4);

		lblApano5 = new JLabel("5");
		lblApano5.setVerticalAlignment(SwingConstants.CENTER);
		lblApano5.setOpaque(true);
		lblApano5.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano5.setForeground(Color.WHITE);
		lblApano5.setBackground(new Color(255, 0, 128));
		lblApano5.setBounds(394, 344, 46, 28);
		lblApano5.setVisible(false);
		panelVotaciones.add(lblApano5);

		lblApano6 = new JLabel("6");
		lblApano6.setVerticalAlignment(SwingConstants.CENTER);
		lblApano6.setOpaque(true);
		lblApano6.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano6.setForeground(Color.WHITE);
		lblApano6.setBackground(new Color(255, 0, 128));
		lblApano6.setBounds(394, 387, 46, 28);
		lblApano6.setVisible(false);
		panelVotaciones.add(lblApano6);

		lblApano7 = new JLabel("7");
		lblApano7.setVerticalAlignment(SwingConstants.CENTER);
		lblApano7.setOpaque(true);
		lblApano7.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano7.setForeground(Color.WHITE);
		lblApano7.setBackground(new Color(255, 0, 128));
		lblApano7.setBounds(394, 426, 46, 28);
		lblApano7.setVisible(false);
		panelVotaciones.add(lblApano7);

		lblApano8 = new JLabel("8");
		lblApano8.setVerticalAlignment(SwingConstants.CENTER);
		lblApano8.setOpaque(true);
		lblApano8.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano8.setForeground(Color.WHITE);
		lblApano8.setBackground(new Color(255, 0, 128));
		lblApano8.setBounds(394, 465, 46, 28);
		lblApano8.setVisible(false);
		panelVotaciones.add(lblApano8);

		lblApano9 = new JLabel("9");
		lblApano9.setVerticalAlignment(SwingConstants.CENTER);
		lblApano9.setOpaque(true);
		lblApano9.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano9.setForeground(Color.WHITE);
		lblApano9.setBackground(new Color(255, 0, 128));
		lblApano9.setBounds(394, 504, 46, 28);
		lblApano9.setVisible(false);
		panelVotaciones.add(lblApano9);

		lblApano10 = new JLabel("10");
		lblApano10.setVerticalAlignment(SwingConstants.CENTER);
		lblApano10.setOpaque(true);
		lblApano10.setHorizontalAlignment(SwingConstants.CENTER);
		lblApano10.setForeground(Color.WHITE);
		lblApano10.setBackground(new Color(255, 0, 128));
		lblApano10.setBounds(394, 545, 46, 28);
		lblApano10.setVisible(false);
		panelVotaciones.add(lblApano10);

		/*
		 * panelTf = new JPanel(); panelTf.setBounds(10, 11, 738, 707);
		 * panelTf.setLayout(null); panelTf.setOpaque(false); panelTf.setVisible(false);
		 * panelVotaciones.add(panelTf);
		 * 
		 * // Elementos del JPanel "panelVotacionesNacionales" lblActuacionEspania = new
		 * JLabel("Actuacion Espania"); lblActuacionEspania.setBounds(10, 11, 256, 177);
		 * lblActuacionEspania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionEspania .setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Grecia.gif")); lblActuacionEspania.setOpaque(true);
		 * panelTf.add(lblActuacionEspania);
		 * 
		 * lblActuacionFrancia = new JLabel("Actuacion Francia");
		 * lblActuacionFrancia.setBounds(10, 241, 256, 177);
		 * lblActuacionFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionFrancia .setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Polonia.gif")); lblActuacionFrancia.setOpaque(true);
		 * panelTf.add(lblActuacionFrancia);
		 * 
		 * lblActuacionAlemania = new JLabel("Actuacion Alemania");
		 * lblActuacionAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionAlemania.setBounds(379, 11, 256, 177); lblActuacionAlemania
		 * .setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/PaisesBajos.gif"));
		 * lblActuacionAlemania.setOpaque(true); //
		 * lblActuacionAlemania.setVisible(false); panelTf.add(lblActuacionAlemania);
		 * 
		 * // JLabels de tlf para votar lblTlfEspania = new
		 * JLabel("tlfno Espania: 678-987-543");
		 * lblTlfEspania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfEspania.setForeground(Color.WHITE); lblTlfEspania.setBounds(43, 199,
		 * 159, 14); panelTf.add(lblTlfEspania);
		 * 
		 * lblTlfAlemania = new JLabel("tlfno Alemania: 765-345-789");
		 * lblTlfAlemania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfAlemania.setForeground(Color.WHITE); lblTlfAlemania.setBounds(434, 199,
		 * 159, 14); panelTf.add(lblTlfAlemania);
		 * 
		 * lblTlfFrancia = new JLabel("tlfno Francia: 879-654-321");
		 * lblTlfFrancia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfFrancia.setForeground(Color.WHITE); lblTlfFrancia.setBounds(43, 442,
		 * 159, 14); panelTf.add(lblTlfFrancia);
		 * 
		 * lblActuacionItalia = new JLabel("Actuacion Italia");
		 * lblActuacionItalia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionItalia.setBounds(379, 241, 256, 177);
		 * lblActuacionItalia.setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Italia.gif")); panelTf.add(lblActuacionItalia);
		 * 
		 * lblTlfItalia = new JLabel("tlfno Italia: 876-543-212");
		 * lblTlfItalia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfItalia.setForeground(Color.WHITE); lblTlfItalia.setBounds(434, 442,
		 * 159, 14); panelTf.add(lblTlfItalia);
		 * 
		 * lblActuacionPortugal = new JLabel("Actuacion Portugal");
		 * lblActuacionPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionPortugal.setBounds(10, 478, 256, 177); lblActuacionPortugal
		 * .setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Portugal.gif")); panelTf.add(lblActuacionPortugal);
		 * 
		 * lblTlfPortugal = new JLabel("tlfno Portugal: 789-876-654");
		 * lblTlfPortugal.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfPortugal.setForeground(Color.WHITE); lblTlfPortugal.setBounds(43, 666,
		 * 159, 14); panelTf.add(lblTlfPortugal);
		 * 
		 * lblActuacionReinoUnido = new JLabel("Actuacion ReinoUnido");
		 * lblActuacionReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionReinoUnido.setBounds(379, 478, 256, 177); lblActuacionReinoUnido
		 * .setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/ReinoUnido.gif"));
		 * panelTf.add(lblActuacionReinoUnido);
		 * 
		 * lblTlfReinoUnido = new JLabel("tlfno ReinoUnido: 897-765-789");
		 * lblTlfReinoUnido.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfReinoUnido.setForeground(Color.WHITE); lblTlfReinoUnido.setBounds(434,
		 * 666, 159, 14); panelTf.add(lblTlfReinoUnido);
		 */

		lblPaisActual = new JLabel("");
		lblPaisActual.setBounds(943, 666, 104, 55);
		lblPaisActual.setOpaque(false);
		lblPaisActual.setBackground(Color.WHITE);
		lblPaisActual.setForeground(Color.WHITE);
		lblPaisActual.setHorizontalAlignment(SwingConstants.CENTER);
		panelVotaciones.add(lblPaisActual);

		lblPaisConsultaVotaciones1 = new JLabel("");
		lblPaisConsultaVotaciones1.setBounds(1167, 610, 170, 44);
		lblPaisConsultaVotaciones1.setOpaque(true);
		lblPaisConsultaVotaciones1.setBackground(Color.WHITE);
		lblPaisConsultaVotaciones1.setVisible(false);
		panelVotaciones.add(lblPaisConsultaVotaciones1);

		lblPaisConsultaVotaciones2 = new JLabel("");
		lblPaisConsultaVotaciones2.setBounds(1165, 677, 170, 44);
		lblPaisConsultaVotaciones2.setOpaque(true);
		lblPaisConsultaVotaciones2.setVisible(false);
		lblPaisConsultaVotaciones2.setBackground(Color.WHITE);
		panelVotaciones.add(lblPaisConsultaVotaciones2);

		lblPaisConsultaVotaciones3 = new JLabel("");
		lblPaisConsultaVotaciones3.setBounds(1167, 743, 170, 44);
		lblPaisConsultaVotaciones3.setOpaque(true);
		lblPaisConsultaVotaciones3.setBackground(Color.WHITE);
		lblPaisConsultaVotaciones3.setVisible(false);
		panelVotaciones.add(lblPaisConsultaVotaciones3);

		lbl15 = new JLabel("15");
		lbl15.setBounds(1121, 610, 46, 44);
		lbl15.setOpaque(true);
		lbl15.setBackground(new Color(250, 237, 39));
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		lbl15.setVisible(false);
		panelVotaciones.add(lbl15);

		lbl10 = new JLabel("10");
		lbl10.setBounds(1121, 677, 46, 44);
		lbl10.setOpaque(true);
		lbl10.setBackground(new Color(250, 237, 39));
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setVisible(false);
		panelVotaciones.add(lbl10);

		lbl8 = new JLabel("8");
		lbl8.setBounds(1121, 743, 46, 44);
		lbl8.setOpaque(true);
		lbl8.setBackground(new Color(250, 237, 39));
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setVisible(false);
		panelVotaciones.add(lbl8);

		lblFondoPanelVotaciones = new JLabel("");
		lblFondoPanelVotaciones.setBackground(new Color(255, 255, 0));
		lblFondoPanelVotaciones.setBounds(-35, 0, 1400, 900);
		lblFondoPanelVotaciones.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/fondo.jpg"));
		panelVotaciones.add(lblFondoPanelVotaciones);

		// JPanel "panelFinal"
		panelFinal = new JPanel();
		panelFinal.setBounds(0, 0, 1400, 900);
		contentPane.add(panelFinal);
		panelFinal.setLayout(null);

		// Elementos del JPanel "panelFinal"
		lblActuacionGanador = new JLabel("");
		lblActuacionGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblActuacionGanador.setBounds(542, 154, 356, 277);
		lblActuacionGanador.setForeground(Color.WHITE);
		panelFinal.add(lblActuacionGanador);

		lblNombreGanador = new JLabel("");
		lblNombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreGanador.setBounds(598, 457, 246, 43);
		lblNombreGanador.setForeground(Color.WHITE);
		lblNombreGanador.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		panelFinal.add(lblNombreGanador);

		lblCancionGanador = new JLabel("");
		lblCancionGanador.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
		lblCancionGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancionGanador.setForeground(Color.WHITE);
		lblCancionGanador.setBounds(580, 536, 282, 43);
		panelFinal.add(lblCancionGanador);

		lblPaisGanador = new JLabel("");
		lblPaisGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisGanador.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
		lblPaisGanador.setForeground(Color.WHITE);
		lblPaisGanador.setBounds(542, 11, 356, 85);
		panelFinal.add(lblPaisGanador);
		panelFinal.setVisible(false);

		lblFondoFinal = new JLabel("");
		lblFondoFinal.setBounds(0, 0, 1400, 900);
		lblFondoFinal.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/fondo2.jpg"));
		panelFinal.add(lblFondoFinal);

		// JPanel "panelInicial"
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 1400, 900);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);

		// Elementos del JPanel "panelInicial"
		btnComenzarInicio = new JButton("COMENZAR");
		btnComenzarInicio.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
		btnComenzarInicio.setBounds(620, 700, 181, 51);
		panelInicial.add(btnComenzarInicio);

		lblLogoInicio = new JLabel("");
		lblLogoInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoInicio.setBounds(0, 0, 1400, 900);
		panelInicial.add(lblLogoInicio);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1400, 900);
		lblFondoInicio.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/fondo2.jpg"));
		panelInicial.add(lblFondoInicio);

		// JPanel "panelVotosNacionales"
		panelVotacionesNacionales = new JPanel();
		panelVotacionesNacionales.setBounds(0, 0, 1400, 900);
		panelVotacionesNacionales.setBackground(new Color(4, 39, 106));

		// Agrega el panel al contentPane
		contentPane.add(panelVotacionesNacionales);

		contentPane.add(panelVotacionesNacionales);
		panelVotacionesNacionales.setLayout(null);
		panelVotacionesNacionales.setVisible(false);

		lblTaylorPaElena = new JLabel("");
		// lblTaylorPaElena.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaylorPaElena.setBounds(1089, 424, 300, 456);
		lblTaylorPaElena.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/taylor/taylor1.png"));
		panelVotacionesNacionales.add(lblTaylorPaElena);
		panelVotacionesNacionales.setLayout(null);
		/*--------------CARRUSEL--------------*/

		btnCarruselAnterior = new JButton("");
		btnCarruselAnterior.setBounds(40, 296, 61, 68);
		btnCarruselAnterior.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/anterior.png"));
		btnCarruselAnterior.setOpaque(false);
		btnCarruselAnterior.setContentAreaFilled(false);
		btnCarruselAnterior.setBorderPainted(true);

		btnCarruselAnterior.setFocusPainted(false);
		btnCarruselAnterior.setContentAreaFilled(false);

		panelVotacionesNacionales.add(btnCarruselAnterior);

		btnCarruselSiguiente = new JButton("");
		btnCarruselSiguiente.setBounds(1280, 296, 61, 68);
		btnCarruselSiguiente.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/siguiente.png"));
		btnCarruselSiguiente.setOpaque(false);
		btnCarruselSiguiente.setContentAreaFilled(false);
		btnCarruselSiguiente.setBorderPainted(true);
		panelVotacionesNacionales.add(btnCarruselSiguiente);

		lblCarrusel = new JLabel("");
		lblCarrusel.setBounds(20, 25, 1343, 700);
		lblCarrusel.setHorizontalAlignment(SwingConstants.CENTER);
		imagenCarrusel = new ImageIcon(System.getProperty("user.dir") + "/resources/actuaciones/1.gif");
		lblCarrusel.setIcon(imagenCarrusel);

		lblCarrusel.setVisible(true);
		panelVotacionesNacionales.add(lblCarrusel);
		// ImageIcon con la imagen que deseas usar como fondo
		ImageIcon imagenFondo = new ImageIcon(System.getProperty("user.dir") + "/resources/fondo.jpg");

		btnComenzarVotaciones = new JButton("ESPERANDO");
		btnComenzarVotaciones.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
		btnComenzarVotaciones.setBounds(550, 782, 272, 33);
		btnComenzarVotaciones.setEnabled(false);
		panelVotacionesNacionales.add(btnComenzarVotaciones);
		// JLabel para mostrar la imagen
		lblFondoTaylor = new JLabel("");
		lblFondoTaylor.setBounds(0, 0, 1400, 900); // Ajusta el tamaño al tamaño del panel
		lblFondoTaylor.setIcon(imagenFondo);

		// Agrega el JLabel al panel
		panelVotacionesNacionales.add(lblFondoTaylor);

		/*
		 * lblActuacionPolonia = new JLabel("Actuacion Polonia");
		 * lblActuacionPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionPolonia.setBounds(455, 185, 196, 123);
		 * lblActuacionPolonia.setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Polonia.gif"));
		 * panelVotacionesNacionales.add(lblActuacionPolonia);
		 * 
		 * lblActuacionPaisesBajos = new JLabel("Actuacion Paises Bajos");
		 * lblActuacionPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionPaisesBajos.setBounds(43, 342, 196, 123);
		 * lblActuacionPaisesBajos.setIcon(new ImageIcon(System.getProperty("user.dir")
		 * + "/resources/actuaciones/PaisesBajos.gif"));
		 * panelVotacionesNacionales.add(lblActuacionPaisesBajos);
		 * 
		 * lblActuacionRumania = new JLabel("Actuacion Rumania");
		 * lblActuacionRumania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionRumania.setBounds(249, 342, 196, 123);
		 * lblActuacionRumania.setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Rumania.gif"));
		 * panelVotacionesNacionales.add(lblActuacionRumania);
		 * 
		 * lblActuacionGrecia = new JLabel("Actuacion Grecia");
		 * lblActuacionGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblActuacionGrecia.setBounds(455, 342, 196, 123);
		 * lblActuacionGrecia.setIcon(new ImageIcon(System.getProperty("user.dir") +
		 * "/resources/actuaciones/Grecia.gif"));
		 * panelVotacionesNacionales.add(lblActuacionGrecia);
		 */

		/*
		 * lblTlfPolonia = new JLabel("tlfno Polonia: 987-987-567");
		 * lblTlfPolonia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfPolonia.setBounds(476, 318, 159, 14);
		 * panelVotacionesNacionales.add(lblTlfPolonia);
		 * 
		 * lblTlfPaisesBajos = new JLabel("tlfno Paises Bajos: 897-543-654");
		 * lblTlfPaisesBajos.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfPaisesBajos.setBounds(53, 475, 176, 14);
		 * panelVotacionesNacionales.add(lblTlfPaisesBajos);
		 * 
		 * lblTlfRumania = new JLabel("tlfno Rumania: 987-456-876");
		 * lblTlfRumania.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfRumania.setBounds(272, 475, 159, 14);
		 * panelVotacionesNacionales.add(lblTlfRumania);
		 * 
		 * lblTlfGrecia = new JLabel("tlfno Grecia: 768-654-123");
		 * lblTlfGrecia.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblTlfGrecia.setBounds(476, 475, 159, 14);
		 * panelVotacionesNacionales.add(lblTlfGrecia);
		 */

		// JPanel "panelAutoria"
		panelAutoria = new JPanel();
		panelAutoria.setBounds(0, 0, 1400, 900);
		contentPane.add(panelAutoria);
		panelAutoria.setLayout(null);
		panelAutoria.setVisible(false);

		// Elementos del JPanel "panelAutoria"
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(656, 708, 102, 28);
		panelAutoria.add(btnVolver);

		lblLogoCentro = new JLabel("");
		lblLogoCentro.setBounds(486, 294, 439, 236);
		lblLogoCentro.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/logos/logoEFA.jpg"));
		panelAutoria.add(lblLogoCentro);

		lblCabecera = new JLabel("2º DAM, EFA Moratalaz");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setBounds(443, 11, 530, 77);
		lblCabecera.setBackground(Color.WHITE);
		lblCabecera.setForeground(Color.WHITE);
		lblCabecera.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		panelAutoria.add(lblCabecera);

		lblAutor1 = new JLabel("Alba Sanchez-Migallón Arias");
		lblAutor1.setBounds(613, 196, 233, 28);
		lblAutor1.setBackground(Color.WHITE);
		lblAutor1.setForeground(Color.WHITE);
		lblAutor1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		panelAutoria.add(lblAutor1);

		lblAutor2 = new JLabel("Elena Cañizares Jimenez");
		lblAutor2.setBounds(625, 144, 233, 28);
		lblAutor2.setBackground(Color.WHITE);
		lblAutor2.setForeground(Color.WHITE);
		lblAutor2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		panelAutoria.add(lblAutor2);

		lblAutor3 = new JLabel("Carlos Guerrero Caro");
		lblAutor3.setBounds(636, 99, 233, 28);
		lblAutor3.setBackground(Color.WHITE);
		lblAutor3.setForeground(Color.WHITE);
		lblAutor3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		panelAutoria.add(lblAutor3);

		lblFondoAutoria = new JLabel("");
		lblFondoAutoria.setBounds(0, 0, 1400, 900);
		lblFondoAutoria.setIcon(new ImageIcon(System.getProperty("user.dir") + "/resources/fondo2.jpg"));
		panelAutoria.add(lblFondoAutoria);
		// JMenuBar "menuBar" con sus respectivos JMenu "mnMenu" y JItemMenu
		// "itemMenuInformacion"
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		itemMenuInformacion = new JMenuItem("Autoría");
		mnMenu.add(itemMenuInformacion);
		menuBar.setBounds(0, 0, getWidth(), 30);
	}

	// Getters requeridos dentro del Timer del controlador, pese a que son elementos
	// declarados como publicos
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
