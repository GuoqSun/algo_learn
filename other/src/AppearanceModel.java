
// 外观模式
public class AppearanceModel {
    public static void main(String[] args) {
        Facade facade = new Facade();
        // 客户端通过调用外观类的方法 来实现对子系统的访问，而不需要直接调用子系统的方法。
        facade.facadeOperation();
    }
}

// 子系统A
class SubSystemA {
    public void operationA() {
        System.out.println("SubsystemA operation");
    }
}

//子系统B
class SubSystemB {
    public void operationB() {
        System.out.println("SubsystemB operation");
    }
}

//子系统C
class SubSystemC {
    public void operationC() {
        System.out.println("SubsystemC operation");
    }
}

//外观类
class Facade {
    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;


    public Facade() {
        this.subSystemA = new SubSystemA();
        this.subSystemB = new SubSystemB();
        this.subSystemC = new SubSystemC();
    }

    // 外观方法，封装了对子系统的操作
    public void facadeOperation() {
        subSystemA.operationA();
        subSystemB.operationB();
        subSystemC.operationC();
    }
}
