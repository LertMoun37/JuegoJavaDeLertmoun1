package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean BtP_A, BtP_B, BtP_Up, BtP_Down, BtP_Left, BtP_Right;  
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		
		switch(code) {
			case KeyEvent.VK_UP: this.BtP_Up = true; break;
			case KeyEvent.VK_LEFT: this.BtP_Left = true; break;
			case KeyEvent.VK_DOWN: this.BtP_Down = true; break;
			case KeyEvent.VK_RIGHT: this.BtP_Right = true; break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int code = e.getKeyCode();
		
		switch(code) {
			case KeyEvent.VK_UP: this.BtP_Up = false; break;
			case KeyEvent.VK_LEFT: this.BtP_Left = false; break;
			case KeyEvent.VK_DOWN: this.BtP_Down = false; break;
			case KeyEvent.VK_RIGHT: this.BtP_Right = false; break;
		}
	}
}