package pratica2.pratica2ponto4;

public class ThreadAR implements Runnable {

    @Override
    public void run() {
        // synchronized faz com que somente uma thread (da mesma instancia) execute o metodo por vez
        // enfileiramento de thread
        
        int threadCont;

        synchronized (this){ 
            App.contador++;
            threadCont = App.contador * 2;
        }

        double prod = threadCont * 50;
        double raiz = Math.sqrt(prod);
        System.out.println(Thread.currentThread().getName() + " escreve " + raiz);

        for (int i = 0; i< 50; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadCont = (int) (threadCont + (Math.random() *20));
            System.out.println(Thread.currentThread().getName() + ": " + threadCont);
        }

    }
    
}
