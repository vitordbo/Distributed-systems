package pratica2.pratica2ponto2;

public class App2 {
    
    static int contador = 0;

    public static void main(String[] args) {
        ThreadAR tar2 = new ThreadAR();

        Thread t0 = new Thread(tar2);
        Thread t1 = new Thread(tar2);
        Thread t2 = new Thread(tar2);
        Thread t3 = new Thread(tar2);
        Thread t4 = new Thread(tar2);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}