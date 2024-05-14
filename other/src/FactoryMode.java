//工厂方法设计模式
// 工厂方法模式引入了抽象工厂和具体工厂的概念，每个具体工厂只负责创建一个具体产品，
// 添加新的产品只需要添加新的工厂类而无需修改原来的代码，这样就使得产品的生产更加灵活，支持扩展，符合开闭原则。
public class FactoryMode {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new circleFactory();
        Shape circle = circleFactory.creatShape();
        circle.draw();

        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.creatShape();
        square.draw();
    }
}

/**
 * 抽象产品
 */
interface Shape {
    void draw();
}

/**
 * 具体产品：圆
 */
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆");
    }
}

/**
 * 具体产品：正方形
 */
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("正方形");
    }
}

/**
 * 抽象工厂
 */
interface ShapeFactory {
    Shape creatShape();
}

/**
 * 具体工厂：圆工厂
 */
class circleFactory implements ShapeFactory {
    @Override
    public Shape creatShape() {
        return new Circle();
    }
}

/**
 * 具体工厂：正方形工厂
 */
class SquareFactory implements ShapeFactory {
    @Override
    public Shape creatShape() {
        return new Square();
    }
}

