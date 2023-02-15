package pratica2.pratica2ponto5;

public class ThreadApp implements Runnable{

    @Override
    public void run() {
        String nome = Thread.currentThread().getName();
        App.lista.add(nome);
        System.out.println(nome + " inseriu na lista!");
    }
    
}
