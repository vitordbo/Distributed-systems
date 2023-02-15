package execucao;

public class Principal {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(new ThreadSoma(10, 20));
        Thread t1 = new Thread(new ThreadSubtracao(10, 20));
        Thread t2 = new Thread(new ThreadProduto(10, 20));

        System.out.println("-----------------------------------");
        t0.start(); 
        t0.join();

        t1.start();    
        t1.join();
        
        t2.start(); 
        t2.join();
        
        Thread t3 = new Thread(new InfoThread());
        t3.start();
        t3.join();
    }
}
