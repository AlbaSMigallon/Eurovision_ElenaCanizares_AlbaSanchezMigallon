package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener{
	public Vista vista;
	public VotacionNacional votacionNacional;
	public Controlador(Vista frame) {
		// TODO Auto-generated constructor stub
		this.vista= vista;
		//this.vista.btnComenzarInicio.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		if(e.getSource()==vista.btnComenzarInicio) {
			//iniciamos proceso de votacion nacional
			vista.panelInicial.setVisible(false);
			vista.panelVotacionesNacionales.setVisible(true);
			try {
				votacionNacional.start();
				votacionNacional.join();
				// habilitamso poder pasar a la fase eurovision tras terminar toda la parte nacional
				vista.btnComenzarVotaciones.setEnabled(true);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		*/		
	}

}
