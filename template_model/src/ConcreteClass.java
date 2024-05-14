// 具体类
public class ConcreteClass extends AbstractClass {
    @Override
    protected void step3() {
        System.out.println("Step 1");
    }

    @Override
    protected void step2() {
        System.out.println("Step 2");
    }

    @Override
    protected void step1() {
        System.out.println("Step 3");
    }
}
