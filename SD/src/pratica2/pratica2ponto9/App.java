package pratica2.pratica2ponto9;

public class App {
    
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10};

        new ThreadApp(array);
        new ThreadApp(array);
        new ThreadApp(array);

    }
}
