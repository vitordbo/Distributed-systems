package pratica2;

public class ThreadAR implements Runnable {

    @Override
    public synchronized void run() {
        // synchronized faz com que somente uma thread (da mesma instancia) execute o metodo por vez
        // enfileiramento de threads 
        App.contador++;
        System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        
    }
    
}
