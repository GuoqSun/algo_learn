/**
 * @author sunguoqiang
 * @date 2024/5/23 13:59
 */
public class PrintUsingVolatile {
    private static volatile int i = 0;
    private static volatile int flag = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static class Thread1 implements Runnable {
        @Override
        public void run() {
            while (i<100){
                if(flag == 0){
                    synchronized (this){
                        if(i<100){
                            System.out.println("t1="+i);
                            i++;
                            flag = 1;
                        }
                    }
                }
            }
        }
    }

    public static class Thread2 implements Runnable {
        @Override
        public void run() {
            while (i<100){
                if(flag == 1){
                    synchronized (this){
                        if(i<100){
                            System.out.println("t2="+i);
                            i++;
                            flag = 2;
                        }

                    }

                }
            }
        }
    }

    public static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (i<100){
                if(flag == 2){
                    synchronized (this){
                        if(i<100){
                            System.out.println("t3="+i);
                            i++;
                            flag = 0;
                        }

                    }

                }
            }
        }
    }
}


