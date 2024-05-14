public class Main {
    public static void main(String[] args) {
        AbstractClass concreteTemplate = new ConcreteClass();
        // 触发整个算法执行
        concreteTemplate.templateMethod();
    }
}
