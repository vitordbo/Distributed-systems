package pratica3.pratica3ponto3;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ImplServidor implements Runnable {

    Socket socketCliente;
    static int contador = 0;
    private boolean conexao = true;
    Scanner entrada;

    public ImplServidor(Socket cliente){
        this.socketCliente = cliente;
    }

    /*
    ' * A classe Thread, que foi instancia no servidor,
    * implementa Runnable. Então
    * você terá que implementar sua
    * lógica de troca de mensagens dentro deste
    * mé
    */

    @Override
    public void run() {
        System.out.println("Conexão " + ImplServidor.contador + " com o cliente "+
        socketCliente.getInetAddress().getHostAddress() + "/" + socketCliente.getInetAddress().getHostName());


        try {
            entrada = new Scanner(socketCliente.getInputStream());
            String mensagem;

            // Exibe mensagem no console
            while (conexao) {
                mensagem = entrada.nextLine();
                
                if (mensagem.equalsIgnoreCase("fim"))
                    conexao = false;
                else
                    System.out.println(mensagem);
            }
            
            // Finaliza scanner e socket
            entrada.close();
            System.out.println("Fim do cliente " + socketCliente.getInetAddress().getHostAddress());
            socketCliente.close();
                    
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
