package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// hereda todo lo de la clase Jpanel (para mostrar graficos y demas elementos) y implementa la funcion runneable (para activar cosas apenas llamando el objeto)
public class PanelJuego extends JPanel implements Runnable {
	
	//Ajustes de pantalla
	
	//Tiles
	final int OriginalTileSize = 16;
	final int escalado = 2;
	final int TileSize = OriginalTileSize * escalado;
	final int PantaColum = 14;
	final int PantaFil   = 18;
	
	//Resolucion
	final int HScreen = PantaColum  * TileSize; // 576
	final int WScreen = PantaFil * TileSize; // 768
	
	//hilo del juego (se puede iniciar y detener)
	
	//fps pues
	final int FPS = 60;
	
	//se crea el thread
	Thread HiloJuego;
	
	
	public PanelJuego (){
		//tamaño, color y buffer de la pantalla (no me acuerdo que significa buffer)
		this.setPreferredSize(new Dimension(WScreen,HScreen));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}

	//inicia el thread
	public void IniciarJuego(){
		
		HiloJuego = new Thread(this);
		HiloJuego.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//interbalo de de dibujo (segundo(en milisegundos) por fps)
		double drawInterval = 1000000000/FPS;
		
		//delta time, un amigo dijo que para dar exactitud a las fisicas se tienen que implementar integrales :,v
		double Dt = 0;
		//tiempo final
		long LastTime = System.nanoTime();
		//tiempo inicial
		long CurrentTime;
		
		//contadores para captar cuantos fps corren
		long Timer = 0;
		long drawCount = 0;
		
		while(HiloJuego != null) {
			
			
			CurrentTime = System.nanoTime();
			
			//asi es el delta time (tiempo actual - tiempo final) dividido por el intervalo de dibujado
			Dt += (CurrentTime - LastTime) / drawInterval;
			Timer += (CurrentTime - LastTime);
			
			LastTime = CurrentTime;
			
			
			//si delta time supera el segundo
			if (Dt >= 1) {
				
			
				Update();
				
				//funcion de jpanel para llamar al dibujado
				repaint();
				
				Dt--;
				
				drawCount++;
			}
			
			//pa captar los fps pe causa
			if (Timer >= 1000000000){
				System.out.println("DeltaTime = " + Dt + "; FPS = " + drawCount);
				drawCount = 0;
				Timer = 0;
			
			}
			
		}
		
		
	}

	//actualización
	public void Update() {
		
	}
	
	//dibujado
	public void paintComponent(Graphics G) {
		
		super.paintComponent(G);
		
		Graphics2D G2 = (Graphics2D)G;
		
		//A
		G2.setColor(Color.GREEN);
		
		G2.fillRect(32, 32, 16, 48);
		G2.fillRect(32+16, 16, 16, 16);
		G2.fillRect(32+16, 32+16, 16, 16);
		G2.fillRect(32+32, 32, 16, 48);
		
		//Y
		G2.setColor(Color.MAGENTA);
		G2.fillRect(64+48, 32, 16, 48);
		G2.fillRect(64+32, 16, 16, 16);
		G2.fillRect(64+64, 16, 16, 16);
		//A
		G2.setColor(Color.white);
		G2.fillRect(128+32, 32, 16, 48);
		G2.fillRect(128+16+32, 16, 16, 16);
		G2.fillRect(128+16+32, 32+16, 16, 16);
		G2.fillRect(128+32+32, 32, 16, 48);	
		//L
		G2.setColor(Color.BLUE);
		G2.fillRect(128+64+32, 16, 16, 48+16);
		G2.fillRect(128+64+48, 64, 16, 16);
		//A
		G2.setColor(Color.red);
		G2.fillRect(128*2+32-16, 32, 16, 48);
		G2.fillRect(128*2+16+32-16, 16, 16, 16);
		G2.fillRect(128*2+16+32-16, 32+16, 16, 16);
		G2.fillRect(128*2+32+32-16, 32, 16, 48);	
		
		//posta ayala es un amigo que me dijo sobre las fisicas y las integrales
		
		//setea el dibujado
		G2.dispose();
	}
	
}
