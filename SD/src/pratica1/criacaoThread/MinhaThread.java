package criacaoThread;

public class MinhaThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()); // nome da thread que esta executando
        System.out.println("Olá mundo paralelo!"); // thread currente 
        // nome da thread que ta acessando o metodo         
    }
    
}