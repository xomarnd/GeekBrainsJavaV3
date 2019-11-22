package Lesson_4;

public class User implements Runnable {
    private Mfu nameMfu;
    private int pageToPrint;
    private int pageToScan;

    User(Mfu nameMFU, int pageToPrint, int pageToScan){
        this.pageToPrint = pageToPrint;
        this.pageToScan = pageToScan;
        this.nameMfu = nameMFU;
    }

    @Override
    public void run(){
        if (pageToPrint > 0) nameMfu.print(pageToPrint);
        else System.out.println(Thread.currentThread().getName() + " not send print.");
        if (pageToScan > 0) nameMfu.scan(pageToScan);
        else System.out.println(Thread.currentThread().getName() + " not send scan.");
    }

}
