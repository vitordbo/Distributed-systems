package pratica3.pratica3ponto1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ImplClienteUDP {
    
    /*
        * DatagramSocket para o cliente
    */
    DatagramSocket socketCliente;
    Scanner sc = new Scanner(System.in);

    public ImplClienteUDP(){
        rodar();
    }

    private void rodar(){
        try {
            socketCliente = new DatagramSocket();
            InetAddress endereco = InetAddress.getByName("localhost");

            System.out.println("Cliente rodando em: " + socketCliente.getLocalPort());

            //entrada de dados do cliente 
            System.out.println("Digite uma mensagem > \n");
            String msg = sc.nextLine();
            
            // tranformando em bytes
            byte[] bufferEnvio = msg.getBytes();

            // Enviar datagrama para destinatário na porta 5050
            DatagramPacket datagramaEnvio = new DatagramPacket(bufferEnvio,bufferEnvio.length,
            endereco,5050);

            System.out.println("Cliente: " + endereco.getHostAddress() + " " + socketCliente.getLocalPort() + 
            "enviando a mensagem " + msg);

            // envia o datagrama 
            socketCliente.send(datagramaEnvio);

            /*
                * Passa um recvBuffer e o tamanho do recvBuffer
                * para receber a mensagem. Se o conteúdo da mensagem
                * recebida for maior que o recvBuffer o excedente é
                * descartado.
            */

            byte[] bufferRecebimento = new byte[1024];

            DatagramPacket datagramaRecebimento = new DatagramPacket(bufferRecebimento,
            bufferRecebimento.length);

            socketCliente.receive(datagramaRecebimento);

            bufferRecebimento = datagramaRecebimento.getData();

            System.out.println("Mensagem recebida: " + new String(bufferRecebimento));

        }catch(SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        
        }catch(IOException e) {
            System.out.println("IO: " + e.getMessage());
        
        } finally {
            sc.close();
            
            // Fechando o socket          
            socketCliente.close();
        }
    }
}
            