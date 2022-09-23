import java.io.IOException;
public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		relojProcess reloj = new relojProcess(5, 55, 55);
		
		reloj.start();
		
		reloj.join();
		
		
	}

}
