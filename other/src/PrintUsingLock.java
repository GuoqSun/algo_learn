import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintUsingLock {
    private int times; //打印次数
    private int state; //当前状态值
    private int count; //需要打印内容的个数
    private Lock lock = new ReentrantLock();

    public PrintUsingLock(int times,int count) {
        this.times = times;
        this.count = count;
    }

    public void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % count == targetNum) {
                state++;
                i++;
                System.out.println(Thread.currentThread().getName()+": "+name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintUsingLock loopThread = new PrintUsingLock(1,3);
        new Thread(()->{
            loopThread.printLetter("B",1);
        },"Thread-B").start();
        new Thread(()->{
            loopThread.printLetter("A",0);
        },"Thread-A").start();
        new Thread(()->{
            loopThread.printLetter("C",2);
        },"Thread-C").start();
    }

}
