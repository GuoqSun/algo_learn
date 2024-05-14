// 模版类
abstract public class AbstractClass {
    //模版方法，定义了算法骨架
    public final void templateMethod(){
        step1();
        step2();
        step3();
    }
    // 抽象方法，由子类实现
    protected abstract void step3();

    protected abstract void step2();

    protected abstract void step1();
}
