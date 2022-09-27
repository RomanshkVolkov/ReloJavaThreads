import java.lang.Thread;

public class relojProcess extends Thread {
	/*   valores globales     valores temporales */ 
	int hora, minuto, segundo;
	String reloj, h, m, s;
	checador check;
	
	
	public relojProcess (int hora, int minuto, int segundo, checador check) {
		this.check = check;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		
	}
	
	public String calculate(int hora, int minuto, int segundo) {
		
		// h m s lo concatena con un 0 para validar 02:02:02 y lo hace string
		if(hora < 10) { h = ("0" + hora); }
		else { h = "" + hora; }
		
		if(minuto < 10) { m = ("0" + minuto); }
		else { m = "" + minuto; }
		
		if(segundo < 10) { s = ("0" + segundo); }
		else { s = "" + segundo; }
		
		reloj = h + ":" + m + ":" + s;
		check.reloj = reloj;
		check.l.setText(reloj);
		check.r.setText("Ingrese su numero de usuario y presione enter");

		System.out.println(reloj);
		return reloj;
	}
	public void run() {
		synchronized(check){
			
		System.out.println("El reloj inicio: ");
		
		while (true) {
			for (;segundo < 60; segundo++) {
				if (hora == 23 && minuto == 60 ) hora = 0; 
				
				try {
					if(check.bandera) {
						sleep(3000);
						segundo = segundo+2;
						check.bandera = false;
						check.notify();
					}else {
						calculate(hora, minuto, segundo);
						sleep(1000);
					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			segundo = 0; minuto++;
			if (minuto == 60 && segundo == 0) { hora++; minuto = 0; }
			if (hora == 24) hora=0;
		}
		
		}
	}
		
	
	
}

