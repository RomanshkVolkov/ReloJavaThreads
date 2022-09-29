import java.lang.Thread;

public class relojProcess extends Thread {
	/* valores globales valores temporales */
	int hora, minuto, segundo;
	String reloj, h, m, s;
	checador check;

	public relojProcess(int hora, int minuto, int segundo, checador check) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.check = check;

	}

	public String calculate(int hora, int minuto, int segundo) {

		// h m s lo concatena con un 0 para validar 02:02:02 y lo hace string
		if (hora < 10) {
			h = ("0" + hora);
		} else {
			h = "" + hora;
		}

		if (minuto < 10) {
			m = ("0" + minuto);
		} else {
			m = "" + minuto;
		}

		if (segundo < 10) {
			s = ("0" + segundo);
		} else {
			s = "" + segundo;
		}

		reloj = h + ":" + m + ":" + s;
		check.reloj = reloj;

		System.out.println(reloj);
		return reloj;
	}

	public void run() {
		while (true) {
			for (; segundo < 60; segundo++) {
				if (hora == 23 && minuto == 60)
					hora = 0;

				try {
					if (check.stop == true) {
						synchronized (check.lock) {
							cronometro cron = new cronometro(hora, minuto, segundo);
							cron.start();
							check.lock.wait();
							hora = cron.gethora();
							minuto = cron.getminuto();
							segundo = cron.getsegundo();
							cron.stop();
						}
					}
					calculate(hora, minuto, segundo);
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			segundo = 0;
			minuto++;
			if (minuto == 60 && segundo == 0) {
				hora++;
				minuto = 0;
			}
			if (hora == 24)
				hora = 0;
		}

	}

}
