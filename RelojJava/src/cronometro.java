
public class cronometro extends Thread {
	int hora, minuto, segundo;

	public cronometro(int hora, int minuto, int segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;

	}

	public int gethora() {
		return hora;
	}

	public int getminuto() {
		return minuto;
	}

	public int getsegundo() {
		return segundo;
	}

	public void run() {
		while (true) {
			for (; segundo < 60; segundo++) {
				if (hora == 23 && minuto == 60)
					hora = 0;
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
