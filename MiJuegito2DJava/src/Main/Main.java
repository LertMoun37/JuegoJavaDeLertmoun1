package Main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		//Usaremos JFrame para crear una ventana
		
		JFrame ventana = new JFrame();
		
		//esta funcion permite que se pueda cerrar la ventana
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//permitir si reescalar ventana
		ventana.setResizable(false);
		//poner titulo
		ventana.setTitle("TestJuegoJava");
		
		//ver clase de PanelJuego Para mas info
		PanelJuego PJuego = new PanelJuego();
		
		//se agrega los elementos de Pjuego a la ventana :v
		ventana.add(PJuego);
		
		//se sella
		ventana.pack();
		
		//no me acuerdo
		ventana.setLocationRelativeTo(null);
		
		//pa ver pues
		ventana.setVisible(true);
		
		//inicia el hilo (PJuego pa mas info)
		PJuego.IniciarJuego();
	}
}
