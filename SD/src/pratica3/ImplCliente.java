package pratica3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ImplCliente {
   
    private Scanner sc;
    private String host;
    private int porta;

    public ImplCliente(String host, int porta){
        this.host = host;
        this.porta = porta;
        rodar();
    }

    private void rodar(){
        try {
            // Conectar ao servidor
            Socket socketCliente = new Socket(host, porta);

            // Cria canal para receber dados (InputStream - Leitura de Dados - Reader)
            DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());

            // Cria canal para enviar dados (OutputStream - Escrita de Dados - Writer)
            DataOutputStream saida = new DataOutputStream(socketCliente.getOutputStream());

            sc = new Scanner(System.in);
            System.out.println("Digite uma mensagem: ");
            String msg = sc.nextLine();

            System.out.println("\n--> Cliente enviando mensagem ao servidor: " + msg);
        
            // envia a mensagem 
            saida.writeUTF(msg); 

            // esperando mensagem 
            msg = entrada.readUTF();

            System.out.println("<-- Cliente recebeu mensagem do servidor: " + msg);

            // fecha os canais de entrada e saida 
            entrada.close();
            saida.close();
            socketCliente.close();

        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }
}
