package Lesson_4;

public class Mfu {
    private Object printLock = new Object();
    private Object scanLock = new Object();
    private final int PRINTSLEEPTIME = 250;
    private final int SCANSLEEPTIME = 1500;


    void print(int pagesToPrint){
        synchronized (printLock){
            for (int i = 1; i <= pagesToPrint; i++) {
                try{
                    Thread.sleep(PRINTSLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> print: " + i + " page.");
            }
        }
    }

    void scan(int pagesToScan){
        synchronized (scanLock){
            for (int i = 1; i <= pagesToScan; i++) {
                try{
                    Thread.sleep(SCANSLEEPTIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " scan: " + i + " page.");
            }
        }
    }
}
