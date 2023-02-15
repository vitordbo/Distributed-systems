package pratica2.pratica2ponto5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    
    static List<String> lista = new ArrayList<>();
    
    public static void main(String[] args) {
        lista = Collections.synchronizedList(lista); // lista sincronizada

        ThreadApp tar = new ThreadApp();

        Thread t0 = new Thread(tar);
        Thread t1 = new Thread(tar);
        Thread t2 = new Thread(tar);

        t0.start();
        t1.start();
        t2.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(lista);
    }
}
