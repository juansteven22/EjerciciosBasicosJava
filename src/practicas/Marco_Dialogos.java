package practicas;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
public class Marco_Dialogos extends JFrame{
	private Lamina_Botones lamina_tipo,lamina_tipo_mensaje,lamina_mensaje,
	lamina_tipo_opcion,lamina_opciones,lamina_entrada;
	public Marco_Dialogos() {
		setTitle("Prueba dediálogos");
		setBounds(500,300,600,450);
		JPanel lamina_cuadricula=new JPanel();
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		String primero[]= {"Mensaje","Confirmar","Opción","Entrada"};
		lamina_tipo=new Lamina_Botones("Tipo", primero);
		lamina_tipo_mensaje=new Lamina_Botones("Tipo Mensaje",new 
		String[] {
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MASSAGE"
						});
		lamina_mensaje=new Lamina_Botones("Mensaje",new 
		String[] {
				"Cadena",
				"Icono",
				"Componente",
				"Otros",
				"Object[]"
						});
		
		lamina_tipo_opcion=new Lamina_Botones("Confirma",new 
		String[] {
				"DEFAULT_OPTION",
				"YES_NOT_OPTION",
				"YES_NOT_CANCEL_OPTION",
				"OK_CANCEL_OPTION"
						});
		
		lamina_opciones=new Lamina_Botones("Opción",new 
		String[] {
				"String[]",
				"Icon[]",
				"Object[]"
						});
		lamina_entrada=new Lamina_Botones("Entrada",new 
		String[] {
				"Campo de texto",
				"Combo"
						});
		
		lamina_cuadricula.add(lamina_tipo);
		lamina_cuadricula.add(lamina_tipo_mensaje);
		lamina_cuadricula.add(lamina_mensaje);
		lamina_cuadricula.add(lamina_tipo_opcion);
		lamina_cuadricula.add(lamina_opciones);
		lamina_cuadricula.add(lamina_entrada);
		// construimos lalamina inferior
		JPanel lamina_mostrar=new JPanel();
		JButton boton_mostar=new JButton("Mostrar");
		lamina_mostrar.add(boton_mostar);
		add(lamina_mostrar,BorderLayout.SOUTH);
		add(lamina_cuadricula, BorderLayout.CENTER);
		
		add(lamina_cuadricula);
	}
}
