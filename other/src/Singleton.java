/**
 * 双重检查锁实现对象单例（多线程）
 */
public class Singleton {
    private volatile Singleton uniqueInstance;

    private Singleton() {
    }

    private Singleton getUniqueInstance() {
        // 先判断对象是否已经实例化过，没有实例化过的才加入锁代码
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                // 再次判断对象是否为空，防止卡在这的线程再次创建实例
                // 某个线程创建了一个实例后，剩余卡在这的线程再拿到时间片，再进行判断，直接返回
                if (uniqueInstance == null) {
                    // 1、分配内存
                    // 2、初始化
                    // 3、返回对象引用
                    // 2和3会重排，导致uniqueInstance为null，会有线程越过第二个判断，导致创建多个对象
                    uniqueInstance = new Singleton(); // 指令重排，volatile解决
                }
            }
        }
        return uniqueInstance;
    }
}
