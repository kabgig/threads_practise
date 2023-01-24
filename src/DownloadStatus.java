public class DownloadStatus {

    private volatile boolean isDone;
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();
    public int getTotalFiles() {
        return totalFiles;
    }
    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytes(){
        synchronized (totalBytesLock){
        totalBytes++;}
    }
    public void incrementTotalFiles(){
        synchronized (totalFilesLock){
            totalFiles++;}
    }
    public boolean isDone() {
        return isDone;
    }
    public void done() {
        isDone = true;
    }
}
