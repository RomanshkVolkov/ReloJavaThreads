import java.lang.Thread;

public class relojProcess extends Thread {
	/*   valores globales     valores temporales */ 
	int hora, minuto, segundo, 
	hh, mm, ss, 
	vh, vm, vs,
	wl = 2;
	String reloj, h, m, s;
	
	
	public relojProcess (int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.vh = 0;
		this.vm = 0;
		this.vs = 0;
	}
	
	public String calculate(int hora, int minuto, int segundo) {
		hh = hora;
		mm = minuto;
		ss = segundo;
		//hh mm ss nos ayudan a modificar los valores sin alterar el ciclo
		
		//vh vm vs nos ayuda a no aumentar los valores en el primer ingreso al ciclo
		
		// h m s lo concatena con un 0 para validar 02:02:02 y lo hace string
		
		/*System.out.println("hora: "+ hora +" minuto: "+ minuto +" segundo: " + segundo);*/
		if (hora == 24 && vh != 0) hh = 0; 
		if (hora == 23 && minuto == 60 && vh != 0) hh = 0;
		if (minuto == 60 && vm != 0) { mm = 0; }
		if (segundo == 60 && vs != 0) { ss = 0; mm++; }
		if (minuto == 59 && segundo == 60 && vm !=0 && vs != 0) { mm = 0; ss = 0; }
		if (hora == 23 && minuto == 59 && segundo == 60) { hh = 0; mm = 0; ss = 0;  }
		
		if(hh < 10) { h = ("0" + hh); }
		else { h = "" + hh; }
		
		if(mm < 10) { m = ("0" + mm); }
		else { m = "" + mm; }
		
		if(this.ss < 10) { s = ("0" + ss); }
		else { s = "" + ss; }
		
		reloj = h + ":" + m + ":" + s;

		System.out.println(reloj);
		return reloj;
	}
	public void run() {
		System.out.println("El reloj inicio en: " + wl);
			while ( wl > 1 ) {
				
				while (hora < 24) {
					if (vh != 0) hora++;
					else vh=1;
					
					while (minuto < 60) {
						if (vm != 0) minuto++;
						else vm=1;
						
						while (segundo < 60) {
							if (vs != 0 ) segundo++;
							else vs=1;
							
							for (int i=0; i < 50; i++) {
								System.out.println();
							}
							calculate(hora, minuto, segundo);
							
							try {
								sleep(1000);
							}catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						segundo = 0;
					}
					minuto = 0;
				}
				hora = 0;
				wl++;
			}
			
	}
	
	
}

