import java.io.IOException;
public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		checador check = new checador();
		relojProcess reloj = new relojProcess(23, 59, 55, check);
		Thread t1 = new Thread(check);
		reloj.start();
		t1.start();
		
		
		reloj.join();
		t1.join();
		
	}

}
