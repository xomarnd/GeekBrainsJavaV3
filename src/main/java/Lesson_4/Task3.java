package Lesson_4;

public class Task3 {
    public static void main(String[] args) {
        Mfu mfu = new Mfu();
        new Thread(new User(mfu,10, 0), "User 1").start();
        new Thread(new User(mfu,9,  1), "User 2").start();
        new Thread(new User(mfu,1,  9), "User 3").start();
        new Thread(new User(mfu,0, 10), "User 4").start();

    }
}
