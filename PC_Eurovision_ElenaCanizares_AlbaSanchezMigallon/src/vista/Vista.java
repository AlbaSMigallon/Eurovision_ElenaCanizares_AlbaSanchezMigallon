package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panelInicial, panelVotacionesNacionales, panelVotacionesEurovision, panelResultados, panelFinal;
	public JLabel lblFondoInicio, lblLogoInicio;
	public JLabel lblActuacionEspania, lblActuacionAlemania, lblActuacionFrancia, lblActuacionItalia,
			lblActuacionPortugal, lblActuacionReinoUnido, lblActuacionPolonia, lblActuacionPaisesBajos,
			lblActuacionRumania, lblActuacionGrecia;
	public JLabel lblTlfEspania, lblTlfAlemania, lblTlfFrancia, lblTlfItalia, lblTlfPortugal, lblTlfReinoUnido,
			lblTlfPolonia, lblTlfPaisesBajos, lblTlfRumania, lblTlfGrecia;
	public JLabel lblTaylorPaElena;
	public JButton btnComenzarInicio, btnComenzarVotaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					Controlador controlador = new Controlador(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// PANEL INICIAL
		panelInicial = new JPanel();
		panelInicial.setBounds(0, 0, 1500, 900);
		contentPane.add(panelInicial);
		panelInicial.setLayout(null);

		

		btnComenzarInicio = new JButton("COMENZAR");
		btnComenzarInicio.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarInicio.setBounds(680, 619, 181, 51);
		panelInicial.add(btnComenzarInicio);
		
		lblLogoInicio = new JLabel("");
		lblLogoInicio.setBounds(297, 189, 887, 405);
		panelInicial.add(lblLogoInicio);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1685, 910);
		lblFondoInicio.setIcon(new ImageIcon(
				"C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo2.jpg"));
		panelInicial.add(lblFondoInicio);
	
		// PANEL VOTOS NACIONALES
		panelVotacionesNacionales = new JPanel();
		panelVotacionesNacionales.setBounds(0, 0, 1500, 900);
		contentPane.add(panelVotacionesNacionales);
		panelVotacionesNacionales.setLayout(null);
		panelVotacionesNacionales.setVisible(false);

		// label de fotos actuaciones

		lblActuacionEspania = new JLabel("");
		lblActuacionEspania.setBounds(343, 56, 237, 154);
		lblActuacionEspania.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\1.gif"));
		panelVotacionesNacionales.add(lblActuacionEspania);

		lblActuacionAlemania = new JLabel("");
		lblActuacionAlemania.setBounds(594, 56, 237, 154);
		lblActuacionAlemania.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\2.gif"));
		panelVotacionesNacionales.add(lblActuacionAlemania);

		lblActuacionFrancia = new JLabel("");
		lblActuacionFrancia.setBounds(1094, 56, 237, 154);
		lblActuacionFrancia.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\3.gif"));
		panelVotacionesNacionales.add(lblActuacionFrancia);

		lblActuacionItalia = new JLabel("");
		lblActuacionItalia.setBounds(847, 56, 237, 154);
		lblActuacionItalia.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\4.gif"));
		panelVotacionesNacionales.add(lblActuacionItalia);

		lblActuacionPortugal = new JLabel("");
		lblActuacionPortugal.setBounds(79, 257, 237, 154);
		lblActuacionPortugal.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\5.gif"));
		panelVotacionesNacionales.add(lblActuacionPortugal);

		lblActuacionReinoUnido = new JLabel("");
		lblActuacionReinoUnido.setBounds(343, 257, 237, 154);
		lblActuacionReinoUnido.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\6.gif"));
		panelVotacionesNacionales.add(lblActuacionReinoUnido);

		lblActuacionPolonia = new JLabel("");
		lblActuacionPolonia.setBounds(1117, 257, 237, 154);
		lblActuacionPolonia.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\7.gif"));
		panelVotacionesNacionales.add(lblActuacionPolonia);

		lblActuacionPaisesBajos = new JLabel("");
		lblActuacionPaisesBajos.setBounds(594, 257, 237, 154);
		lblActuacionPaisesBajos.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\8.gif"));
		panelVotacionesNacionales.add(lblActuacionPaisesBajos);

		lblActuacionRumania = new JLabel("");
		lblActuacionRumania.setBounds(755, 257, 237, 154);
		lblActuacionRumania.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\9.gif"));
		panelVotacionesNacionales.add(lblActuacionRumania);

		lblActuacionGrecia = new JLabel("");
		lblActuacionGrecia.setBounds(79, 56, 237, 154);
		lblActuacionGrecia.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\actuaciones\\10.gif"));
		panelVotacionesNacionales.add(lblActuacionGrecia);

		// labels de tlf para votar
		lblTlfEspania = new JLabel("");
		lblTlfEspania.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfEspania);

		lblTlfAlemania = new JLabel("");
		lblTlfAlemania.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfAlemania);

		lblTlfFrancia = new JLabel("");
		lblTlfFrancia.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfFrancia);

		lblTlfItalia = new JLabel("");
		lblTlfItalia.setBounds(917, 422, 330, 36);
		panelVotacionesNacionales.add(lblTlfItalia);

		lblTlfPortugal = new JLabel("");
		lblTlfPortugal.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfPortugal);

		lblTlfReinoUnido = new JLabel("");
		lblTlfReinoUnido.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfReinoUnido);

		lblTlfPolonia = new JLabel("");
		lblTlfPolonia.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfPolonia);

		lblTlfPaisesBajos = new JLabel("");
		lblTlfPaisesBajos.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfPaisesBajos);

		lblTlfRumania = new JLabel("");
		lblTlfRumania.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfRumania);

		lblTlfGrecia = new JLabel("");
		lblTlfGrecia.setBounds(917, 230, 46, 14);
		panelVotacionesNacionales.add(lblTlfGrecia);

		lblTaylorPaElena = new JLabel("");
		lblTaylorPaElena.setBounds(153, 454, 302, 456);
		lblTaylorPaElena.setIcon(new ImageIcon("C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\taylor\\taylor1.png"));
		panelVotacionesNacionales.add(lblTaylorPaElena);

		btnComenzarVotaciones = new JButton("ESPERANDO");
		btnComenzarVotaciones.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnComenzarVotaciones.setBounds(742, 708, 89, 23);
		btnComenzarVotaciones.setEnabled(false);
		panelVotacionesNacionales.add(btnComenzarVotaciones);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1685, 910);
		lblFondoInicio.setIcon(new ImageIcon(
				"C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo2.jpg"));
		panelVotacionesNacionales.add(lblFondoInicio);
		/*
		// PANEL VOTOS POR PAISES EUROVISION
		panelVotacionesEurovision = new JPanel();
		panelVotacionesEurovision.setBounds(0, 0, 1500, 900);
		contentPane.add(panelVotacionesEurovision);
		panelVotacionesNacionales.setLayout(null);

		lblFondoInicio = new JLabel("");
		lblFondoInicio.setBounds(0, 0, 1685, 910);
		lblFondoInicio.setIcon(new ImageIcon(
				"C:\\Users\\Alba\\git\\Eurovision_ElenaCanizares_AlbaSanchezMigallon\\PC_Eurovision_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo2.jpg"));
		panelInicial.add(lblFondoInicio);

		// PANEL RESULTADOS FINALES EUROVISION
		panelResultados = new JPanel();
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
		panelInicial.add(lblFondoInicio);
*/
	}
	
}
