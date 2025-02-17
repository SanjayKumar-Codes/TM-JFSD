package Consolidated_tasks.tasks2;

// Creating a thread by extending the Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello, Java!");
    }
}

public class Hellothread {
    public static void main(String[] args) {
        // Create and start the thread
        MyThread thread = new MyThread();
        thread.start();
    }
}
