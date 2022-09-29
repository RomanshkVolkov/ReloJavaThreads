
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
			for (segundo = 0; segundo < 60; segundo++) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (segundo == 59) {
					minuto++;
					if (minuto == 60) {
						minuto = 0;
						hora++;
					}
					if (hora == 24) {
						hora = 0;
					}
				}
			}
		}
	}
}
