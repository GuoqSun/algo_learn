// 观察者模式
// 小明所在的学校有一个时钟（主题），每到整点时，它就会通知所有的学生（观察者）当前的时间，
// 请你使用观察者模式实现这个时钟通知系统。
// 注意点：时间从 0 开始，并每隔一个小时更新一次。

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 观察者接口
 */
interface Observer {
    //更新方法
    void update(int hour);
}

/**
 * 主题接口
 */
interface Subject {
    //注册观察者
    void registerObserver(Observer observer);

    //移除观察者
    void removeObserver(Observer observer);

    //通知观察者
    void notifyObserver();
}

/**
 * 具体主题实现
 */
class Clock implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int hour;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(hour);
        }
    }

    public void tick() {
        hour = (hour + 1) % 24;
        notifyObserver();
    }
}

/**
 * 具体观察者实现
 */
class Student implements Observer {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(int hour) {
        System.out.println(name + " " + hour);
    }
}

/**
 * 测试类
 */
public class Observe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Clock clock = new Clock();
        for (int i = 0; i < N; i++) {
            String studentName = sc.next();
            clock.registerObserver(new Student(studentName));
        }
        int updates = sc.nextInt();
        for (int i = 0; i < updates; i++) {
            clock.tick();
        }
    }
}
