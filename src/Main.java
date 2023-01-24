import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> collection =
                Collections.synchronizedCollection(new ArrayList<>());

        Thread thread1 = new Thread (() ->
                collection.addAll(Arrays.asList(1,2,3)));
        Thread thread2 = new Thread (() ->
                collection.addAll(Arrays.asList(4,5,6)));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
    }
}