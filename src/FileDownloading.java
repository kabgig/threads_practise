public class FileDownloading implements Runnable {
    private DownloadStatus status;

    public FileDownloading(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread()
                .getName() + " started");
        for (int i = 0; i < 1_000_000; i++) {
            status.incrementTotalBytes();
        }
        status.done();
        synchronized (status){
        status.notifyAll();}

    }
}
