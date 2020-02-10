package Lesson_4;

class Task1 {
    private final Object mon = new Object ();
    private volatile char currentLetter = 'A';
    private final int NOT = 5;

    public static void main(String[] args) {
        Task1 w = new Task1 ();
        Thread t1 = new Thread (() -> {
            w.printA ();
        });
        Thread t2 = new Thread (() -> {
            w.printB ();
        });
        Thread t3 = new Thread (() -> {
            w.printC ();
        });
        t1.start ();
        t2.start ();
        t3.start ();
    }

    void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < NOT; i++) {
                    while (currentLetter != 'A') {
                        mon.wait ();
                    }
                    System.out.print ("A");
                    currentLetter = 'B';
                    mon.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < NOT; i++) {
                    while (currentLetter != 'B') {
                        mon.wait ();
                    }
                    System.out.print ("B");
                    currentLetter = 'C';
                    mon.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

    void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < NOT; i++) {
                    while (currentLetter != 'C') {
                        mon.wait ();
                    }
                    System.out.print ("C");
                    currentLetter = 'A';
                    mon.notifyAll ();
                }
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
}
