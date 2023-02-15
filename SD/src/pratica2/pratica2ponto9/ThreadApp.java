package pratica2.pratica2ponto9;

public class ThreadApp implements Runnable {
    
    static Recurso recurso = new Recurso();
    int[] numeros;

    public ThreadApp(int[] n){
        this.numeros = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        String nome = Thread.currentThread().getName();   
        System.out.println(nome + " => começou"); 
        
        int soma = recurso.somaVetor(numeros);
        System.out.println(nome + " - resultado da soma do vetor: " + soma);
        System.out.println(nome + " => terminou");     
    }
}
