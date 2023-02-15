package pratica2.pratica2ponto2;

public class ThreadAR2 implements Runnable {

    Object porta1 = new Object();
    Object porta2 = new Object();

    @Override
    public void run() {
        // synchronized faz com que somente uma thread (da mesma instancia) execute o metodo por vez
        // enfileiramento de thread

        synchronized (porta1){ 
            App.contador++;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }

        synchronized (porta2){ 
            App.contador--;
            System.out.println(Thread.currentThread().getName() + " : " + App.contador);
        }
    }
    
}

