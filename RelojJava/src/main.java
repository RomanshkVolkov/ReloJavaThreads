import java.io.IOException;
public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		relojProcess reloj = new relojProcess(23, 59, 55);
		
		new checador(reloj);
		reloj.start();
		
		reloj.join();
		
		
	}

}
