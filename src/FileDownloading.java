public class FileDownloading implements Runnable {
    private DownloadStatus status;

    public FileDownloading() {
        this.status = new DownloadStatus();
    }

    @Override
    public void run() {
        System.out.println("File downloading " + Thread.currentThread().getName());
        for (int i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.incrementTotalBytes();
        }
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
