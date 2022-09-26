import java.awt.*;    
import java.awt.event.*;
import java.util.Scanner;

public class checador extends Frame implements KeyListener {
	Label l, r, l3;
	TextArea area;    
	static Scanner sc = new Scanner(System.in);
	String txtRecord, t1;
	char temp;
	static register rd = new register();
	String reloj;
	boolean bandera = false;

	checador() {
		l = new Label();
		l.setBounds (160, 50, 250, 20);
		r = new Label();
		r.setBounds (50, 70, 250, 20);
		l3 = new Label();
		l3.setBounds(120, 120, 250, 20);
		area = new TextArea();
		area.setBounds (150, 100, 100, 20);
		area.addKeyListener(this);
		add(l);  
		add(r);
		add(l3);
		add(area);
		setSize (400, 170);    
        setLayout (null);    
        setVisible (true);
	}
	
	@Override
	
	public void keyTyped(KeyEvent e) {
		  
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {

			bandera = true;
			txtRecord = area.getText();
			//l.setText(rd.entry.toString());
			txtRecord = txtRecord.replaceAll("\n", "");
			txtRecord = txtRecord.replaceAll("\r", "");
			record("Usuario No. " + txtRecord);
			area.setText("");
			area.setCaretPosition(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//l.setText ("Hora de registro: "); 
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		 //area.setText("");
		 //l.setText (""); 
	}
	
	public void record (String txt) {
		if (rd.entry.contains(txt)) { 
			t1 = l3.getText();
			rd.history.add(t1 + " - " + txt +" salida: " + reloj);
			rd.entry.remove(txt);
			l.setText(txt +" salida: " + reloj);
			l3.setText(txt +" salida: " + reloj);
			r.setText("");
		}
		else {
			rd.entry.add(txt);
			l.setText(txt +" entrada: " + reloj); 
			l3.setText(txt +" entrada: " + reloj); 
			r.setText("");
		}
		return;
		
	}

}
