import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new FileDownloading(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Total bytes: " + status.getTotalBytes());


    }
}