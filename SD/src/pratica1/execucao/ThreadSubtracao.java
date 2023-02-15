package execucao;

public class ThreadSubtracao  implements Runnable {
    Integer v1, v2;

    public ThreadSubtracao(Integer n1, Integer n2){
        this.v1 = n1;
        this.v2 = n2;
    }

    @Override
    public void run() {
        System.out.println("Thread subtração: " + (v1 - v2));
    }
    
}
