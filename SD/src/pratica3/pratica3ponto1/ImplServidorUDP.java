package pratica3.pratica3ponto1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ImplServidorUDP {
    
    private int porta;
    private InetAddress host;
    DatagramSocket socketServidor = null;

    public ImplServidorUDP(int porta){

        this.porta = porta;
        rodar(this.porta);
    }

    private void rodar(int porta2){

        try {
            // DatagramSocket servidor na porta 5050.
            socketServidor = new DatagramSocket(porta2);
            host = InetAddress.getLocalHost();

            System.out.println("Servidor executando no endereço: " + host + ":" + porta2);

            // Cria o datagrama para receber uma mensagem.
            byte[] bufferRecebimento = new byte[1024];

            DatagramPacket datagramaRecebimento = new DatagramPacket(bufferRecebimento, 
            bufferRecebimento.length);

            // bloqueia ate receber == Aguarda até o recebimento de uma mensagem.
            socketServidor.receive(datagramaRecebimento);

            bufferRecebimento = datagramaRecebimento.getData();

            String msg = new String(bufferRecebimento);

            System.out.println("Servidor recebeu a mensagem < " + msg);
            System.out.println("Preparando uma resposta...");

            // Enviando uma resposta
            String msgResposta = "resposta: " + inverteString(msg);

            byte[] bufferEnvio = msgResposta.getBytes();

            DatagramPacket pacoteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length,
            datagramaRecebimento.getAddress(), datagramaRecebimento.getPort());

            socketServidor.send(pacoteEnvio);

            System.out.println("Servidor enviou a resposta: " + msgResposta);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        
        } finally {
            // Fechando o servidor.
            if (socketServidor != null) {
                socketServidor.close();
            }
        }
    }
            
    public String inverteString(String s) {
        String retorna = "";
        s = s.trim();
        int len = s.length();
        
        for (int i = len; i > 0; i--) {
            if (i - 1 >= 0)
            retorna = retorna + s.charAt(i - 1);
        }

        return retorna;
    }
    
}

