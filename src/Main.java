public class Main {
    public static void main(String[] args) {
        var status = new DownloadStatus();
        Thread thread1 = new Thread(
                new FileDownloading(status));
        Thread thread2 = new Thread(() -> {
             while(!status.isDone()){
                 synchronized (status){
                 try {
                     status.wait();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }}
             }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

    }
}