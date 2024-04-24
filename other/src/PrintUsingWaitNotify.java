public class PrintUsingWaitNotify {
    private int state;
    private int times;
    private int count;

    private static final Object LOCK = new Object();
    public PrintUsingWaitNotify(int times,int count){
        this.times = times;
        this.count = count;
    }

    public void printLetter(String name,int targetStat){
        for(int i=0;i<times;i++){
            synchronized (LOCK){
                while (state % count!=targetStat){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintUsingWaitNotify printABC = new PrintUsingWaitNotify(1,3);
        new Thread(()->{
            printABC.printLetter("B",1);
        },"B").start();
        new Thread(()->{
            printABC.printLetter("A",0);
        },"A").start();
        new Thread(()->{
            printABC.printLetter("C",2);
        },"C").start();
    }
}
