import java.awt.*;    
import java.awt.event.*;
import java.util.Scanner;

public class checador extends Frame implements KeyListener {
	Label l, r; 
	TextArea area;    
	static Scanner sc = new Scanner(System.in);
	String txtRecord, t1;
	char temp;
	static register rd = new register();
	String reloj;
	boolean bandera = false;

	checador() {
		l = new Label();
		l.setBounds (20, 50, 250, 20);
		r = new Label();
		r.setBounds (20, 70, 300, 20);
		area = new TextArea();
		area.setBounds (20, 80, 300, 300);
		area.addKeyListener(this);
		add(l);  
		add(r);
		add(area);
		setSize (400, 400);    
        setLayout (null);    
        setVisible (true);
	}
	
	@Override
	
	public void keyTyped(KeyEvent e) {
		  
		bandera = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			
			txtRecord = area.getText();
			//l.setText(rd.entry.toString());
			txtRecord = txtRecord.replaceAll("\n", "");
			txtRecord = txtRecord.replaceAll("\r", "");
			record(txtRecord);
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
			rd.out.add(txt);
			l.setText(txt +" salida: " + reloj);
			r.setText("");
		}
		else {
			rd.entry.add(txt);
			l.setText(txt +" entrada: " + reloj); 
			r.setText("");
		}
		return;
		
	}

}
