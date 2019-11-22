package Lesson_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class Task2 {
    private final Object file = new Object();
    private File treadOutFile = new File("./src/res/out.txt");
    private final int SLEEPTIME = 2000;

    public static void main(String[] args) {
        fileWithDirectoryAssurance();
        Task2 write = new Task2 ();
        write.startThread ();

//        while (true) {
//            Task2 write = new Task2 ();
//            write.startThread ();
//        }
    }

    private void startThread() {
        Thread t1 = new MyThread();
        t1.start();
        Thread t2 = new MyThread();
        t2.start();
        Thread t3 = new MyThread();
        t3.start();
    }

    private static void fileWithDirectoryAssurance() {
        File dir = new File("./src/res/");
        if (!dir.exists()) dir.mkdirs();
        new File("./src/res/out.txt");
    }

    private void writeToFileThread(String nameTrhead){
        try {
            FileWriter fileWriter = new FileWriter(treadOutFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < 10; i ++) {
                bufferedWriter.write ("Thread " + nameTrhead + ": " + i + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run");
            synchronized (file) {
                System.out.println(Thread.currentThread().getName() + " write to file");
                try {
                    writeToFileThread(Thread.currentThread().getName());
                    Thread.sleep(SLEEPTIME);
                    System.out.println(Thread.currentThread().getName() + " sleep");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " stop sleep");
            }

        }
    }

}
