package execucao;

public class ThreadSoma implements Runnable {

    Integer v1, v2;

    public ThreadSoma(Integer n1, Integer n2){
        this.v1 = n1;
        this.v2 = n2;
    }

    @Override
    public void run() {
        System.out.println("Thread soma: " + (v1 + v2));
    }
    
}
