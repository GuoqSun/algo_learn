import java.util.Date;

/**
 * 简单的Runnable类，需要5s来执行其任务
 *
 * @author sunguoqiang
 * @date 2024/5/23 11:31
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time= " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time= " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
