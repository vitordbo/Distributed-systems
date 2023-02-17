package pratica3.pratica3ponto2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ImplClienteSemThread {
    
    Socket cliente = null;
    InetAddress inet = null;
    Scanner teclado = null;
    PrintStream saida;
    String ip;
    int porta;

    public ImplClienteSemThread(String ip, int porta){
        this.ip = ip;
        this.porta = porta;
        this.rodar();
    }

    private void rodar() {
        try {
            
            cliente = new Socket(ip, porta);

            System.out.println("Cliente se conectou");

            inet = cliente.getInetAddress();
            System.out.println("HostAddress = " + inet.getHostAddress());
            System.out.println("Hostname: " + inet.getHostName());

            teclado = new Scanner(System.in);
            saida = new PrintStream(cliente.getOutputStream());
            
            while(teclado.hasNextLine()) {
                saida.println(teclado.nextLine());
            }
            
            saida.close();
            teclado.close();
            cliente.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
