package execucao;

public class InfoThread implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        
        System.out.println("Viva? " + t.isAlive());
        System.out.println("Nome: " + t.getName());
        System.out.println("Id: " + t.getId());
        System.out.println("Prioridade: " + t.getPriority());
        System.out.println("Estado: " + t.getState());
        System.out.println("Viva: " + t.isAlive());
    }
    
}
