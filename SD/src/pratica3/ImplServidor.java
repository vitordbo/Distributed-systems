package pratica3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ImplServidor {
    private int porta;

    public ImplServidor(int porta){
        this.porta = porta;
        rodar();

    }

    private void rodar(){
        try {
            // Cria um socket servidor na porta 5000
            ServerSocket socketServidor = new ServerSocket(this.porta);
            
            System.out.println("=== Iniciando servidor TCP ===\n");
            System.out.println("=== Servidor pronto para receber conexões ===\n");

            /**
                * O metodo accept retorna um socket para comunicação com o próximo cliente a conectar.
                * A execução do método bloqueia até que algum cliente conecte no servidor.
            */

            Socket socket = socketServidor.accept();

            // imprime o ip do cliente
            System.out.println("Nova conexão com o cliente: " + socket.getInetAddress().getHostAddress());

            // Cria um canal para receber dados (InputStream - Leitura de Dados - Reader)
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            // Cria um canal para enviar dados (OutputStream - Escrita de Dados - Writer)
            DataOutputStream saida = new DataOutputStream(socket.getOutputStream());

            //Aguarda o recebimento de uma string.
            String msg = entrada.readUTF();

            System.out.println("--> Mensagem recebida: " + msg);

            msg = "Bem vindo e tchau!";

            System.out.println("--> Servidor enviando mensagem: " + msg);

            // Fecha os canais in e out do socket que estão atendendo ao cliente
            saida.writeUTF(msg);

            
            entrada.close();
            saida.close();

            // Fecha o socket para o cliente.
            socket.close();

            System.out.println("\n=== Conexão finalizada ===\n");
            // Fechando o servidor.
            socketServidor.close();


        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
