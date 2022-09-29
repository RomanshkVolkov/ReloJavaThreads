import java.awt.*;
import java.awt.event.*;

public class checador extends Frame implements KeyListener, Runnable {
	public boolean stop = false;
	Label l, r, l3;
	TextArea area;
	String txtRecord, t1;
	char temp;
	static register rd = new register();
	String LocalTime;
	boolean bandera = false;

	Object lock = new Object();
	public String reloj;

	public checador() {
		l = new Label();
		l.setBounds(160, 50, 250, 20);
		r = new Label();
		r.setBounds(50, 70, 300, 20);
		l3 = new Label();
		l3.setBounds(120, 120, 250, 20);
		area = new TextArea();
		area.setBounds(150, 100, 100, 20);
		area.addKeyListener(this);
		add(l);
		add(r);
		add(l3);
		add(area);
		setSize(400, 170);
		setLayout(null);
		setVisible(true);
	}

	@Override

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			bandera = true;
		}
		if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
			System.out.println("DESPERTAR HILO RELOJ");
			stop = false;
			bandera = false;
			synchronized (lock) {
				lock.notify();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (bandera == true) {

				registerCheck();
				area.setText("");
				stop = true;
				r.setText("Presione esc para continuar");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				if (stop) {
					r.setText("Presione ESC para registrar");
				} else {
					l.setText(reloj);
					r.setText("Ingrese su usuario y presione ENTER para registrar");
				}
				// if (relojHilo.stop) {

				// }
			}

		}

	}

	public void registerCheck() {
		txtRecord = area.getText();
		// l.setText(rd.entry.toString());
		txtRecord = txtRecord.replaceAll("\n", "");
		txtRecord = txtRecord.replaceAll("\r", "");
		record("Usuario No. " + txtRecord);
		area.setText("");
		area.setCaretPosition(0);
		bandera = false;
	}

	public void record(String txt) {
		LocalTime = reloj;
		// marcar el registro en pantalla
		if (rd.entry.contains(txt)) {
			t1 = l3.getText();
			rd.history.add(t1 + " - " + txt + " salida: " + LocalTime);
			rd.entry.remove(txt);
			l.setText(txt + " salida: " + LocalTime);
			l3.setText(txt + " salida: " + LocalTime);
			r.setText("");
		} else {
			rd.entry.add(txt);
			l.setText(txt + " entrada: " + LocalTime);
			l3.setText(txt + " entrada: " + LocalTime);
			r.setText("");
		}
		return;

	}
}
