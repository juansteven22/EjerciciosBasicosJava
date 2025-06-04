package practicas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.*;
public class Marco_Dialogos extends JFrame{
	private Lamina_Botones lamina_tipo,lamina_tipo_mensaje,lamina_mensaje,
	lamina_tipo_opcion,lamina_opciones,lamina_entrada;
	private String cadenaMensaje="Mensaje";
	private Icon iconoMensaje=new ImageIcon("C:\\Users\\JuanStevenMontenegro\\Desktop\\n_bola_azul.gif");
	private Object objetoMensaje=new Date();
	private Lamina_Ejemplo componenteMensaje=new Lamina_Ejemplo();
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
				"WARNING_MESSAGE",
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
		JButton boton_mostrar=new JButton("Mostrar");
		boton_mostrar.addActionListener(new AccionMostrar());
		lamina_mostrar.add(boton_mostrar);
		add(lamina_mostrar,BorderLayout.SOUTH);
		add(lamina_cuadricula, BorderLayout.CENTER);
		
		add(lamina_cuadricula);
	}
	
	//------- INICIO PROPORCIONA EL MENSAJE------------
	
	public Object dameMensaje() {
		String s=lamina_mensaje.dameSeleccion();
		if(s.equals("Cadena")) {
			return cadenaMensaje;
		}
		else if(s.equals("Icono")) {
			return iconoMensaje;
		}
		else if(s.equals("Componente")) {
			return componenteMensaje;
		} 
		else if(s.equals("Otros")) {
			return objetoMensaje;
		}
		else if(s.equals("Object[]")) {
			return new Object[] {
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}
		else {
			return null;
		}
	}
	
	//------- FIN  PROPORCIONA EL MENSAJE------------
	//------- iniico devuelve icono y numero de botnes en confirmar------------------------
	public int dameTipo(Lamina_Botones lamina) {
		String s=lamina.dameSeleccion();
		if(s.equalsIgnoreCase("ERROR_MESSAGE")||s.equals("YES_NOT_OPTIONS")) {
			return 0;
		}
		else if (s.equals("INFORMATION_MESSAGE")||s.equals("YES_NOT_CANCEL_OPTION")){
			return 1;
		}
		else if (s.equals("WARNING_MESSAGE")||s.equals("OK_CANCEL_OPTION")){
			return 2;
		}
		else if (s.equals("QUESTION_MESSAGE")){
			return 3;
		}
		else if (s.equals("PLAIN_MESSAGE")||s.equals("DEFAULT_OPTION")){
			return -1;
		}
		else {
			return 0;
		}

	}

	// ----------------------INICIO Da opciones a la lamina7
	public Object[] dameOpciones(Lamina_Botones lamina) {
		String s=lamina.dameSeleccion();
		if(s.equals("String[]")) {
			return new String[] {
					"Amarillo","Azul","Rojo"
			};
		}
		else if(s.equals("Icon[]")) {
			return new Object[] {
					new ImageIcon("C:\\Users\\JuanStevenMontenegro\\Desktop\\bola_azul.gif"),
					new ImageIcon("C:\\Users\\JuanStevenMontenegro\\Desktop\\bola_roja.gif"),
					new ImageIcon("C:\\Users\\JuanStevenMontenegro\\Desktop\\bola_amarilla.gif")
					
					

			};
		}
		else if(s.equals("Object[]")) {
			return new Object[] {
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}
		else {
			return null;
		}
		
	}
	// ----------------------FIN Da opciones a la lamina
	
	
	//------- fin devuelve icono ------------------------
	private class AccionMostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(lamina_tipo.dameSeleccion());
			if(lamina_tipo.dameSeleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(Marco_Dialogos.this, dameMensaje(),"titulo",dameTipo(lamina_tipo_mensaje));
			}
			else if(lamina_tipo.dameSeleccion().equals("Confirmar")) {
				JOptionPane.showConfirmDialog(Marco_Dialogos.this,dameMensaje(),"titulo",dameTipo(lamina_tipo_opcion),dameTipo(lamina_tipo_opcion));
			}
			else if(lamina_tipo.dameSeleccion().equals("Entrada")) {
			    if(lamina_entrada.dameSeleccion().equals("Campo de texto")) {
			        JOptionPane.showInputDialog(Marco_Dialogos.this, dameMensaje(), "titulo", dameTipo(lamina_tipo_mensaje));
			    }
			    else {
			        JOptionPane.showInputDialog(
			            Marco_Dialogos.this,
			            dameMensaje(),
			            "titulo",
			            dameTipo(lamina_tipo_mensaje),
			            null, // Icono
			            new String[] {"Amarillo", "Azul", "Rojo"},
			            "Azul"
			        );
			    }
			}

			else if(lamina_tipo.dameSeleccion().equals("Opción")) {
				JOptionPane.showOptionDialog(
						Marco_Dialogos.this, 
						dameMensaje(), 
						"Titulo", 
						 1,
						 dameTipo(lamina_tipo_mensaje), 
						 null, 
						 dameOpciones(lamina_opciones), 
						 null
						 );
			}
		}
		
	}
	
}



//Definimos una clase llamada Lamina_Ejemplo que extiende JPanel
//Esto significa que Lamina_Ejemplo es un panel gráfico donde podemos dibujar
class Lamina_Ejemplo extends JPanel {

 // Sobrescribimos (override) el método paintComponent que se encarga de dibujar en el panel
 // El parámetro Graphics g es el objeto que nos permite dibujar en el panel
 public void paintComponent(Graphics g) {
     // Primero llamamos al método paintComponent de la superclase (JPanel)
     // Esto limpia el panel y hace que se dibuje correctamente el fondo por defecto
     super.paintComponent(g);

     // Convertimos el objeto Graphics a Graphics2D para tener acceso a más funcionalidades avanzadas de dibujo
     Graphics2D g2 = (Graphics2D) g;

     // Creamos un rectángulo usando Rectangle2D.Double
     // El rectángulo empieza en la posición (0,0) que es la esquina superior izquierda del panel
     // getWidth() y getHeight() obtienen el ancho y alto actuales del panel, para que el rectángulo cubra todo el panel
     Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());

     // Establecemos el color de pintura a amarillo
     g2.setPaint(Color.YELLOW);

     // Rellenamos el rectángulo con el color amarillo
     g2.fill(rectangulo);
 }
}
