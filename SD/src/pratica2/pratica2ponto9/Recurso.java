package pratica2.pratica2ponto9;

public class Recurso {
    int soma;

    public int somaVetor(int[] n){

        soma = 0;
        for (int i =0; i < n.length; i++){
            soma += n[i];
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return soma;
    }
}
