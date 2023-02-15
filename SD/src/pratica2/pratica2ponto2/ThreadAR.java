package pratica2.pratica2ponto2;

public class ThreadAR implements Runnable {

    @Override
    public void run() {
        // synchronized faz com que somente uma thread (da mesma instancia) execute o metodo por vez
        // enfileiramento de thread
        
        //int v = (int) (Math.random() * 50);

        synchronized (this){ 
            App.contador++;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        synchronized (this){ 
            App.contador--;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }
    }
    
}
