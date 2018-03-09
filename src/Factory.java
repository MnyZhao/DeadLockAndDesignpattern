import javax.sound.midi.Track;

/**
 * 简单工厂模式，
 * 定义一个类根据参数传入参数的不同创建不同的实例返回
 */
public class Factory {
   public static void main(String[] args){
       Shape shape=GetShapeFactory.getShape(1);
   }
}

/**
 * 实例
 * 创建一个可以生成不同形状的绘图工具 可以绘制各种图形 每种图形都有draw方法来绘制.
 * 我们可以先声明一个接口  或者抽象类  因为接口方便扩展可以多实现所以 用接口
 */
interface Shape {
    void draw();
}
/*圆形*/
class CircleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("CircleShape.draw");
    }
}
/*矩形*/
class RectShape implements Shape {
    @Override
    public void draw() {
        System.out.println("RectShape.draw");
    }
}
/*三角形*/
class TriangleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("TriangleShape.draw");
    }
}

class GetShapeFactory {
    public static Shape getShape(int type) {
        Shape shape = null;
        switch (type) {
            case 1:
                shape = new CircleShape();
            case 2:
                shape = new RectShape();
                break;
            case 3:
                shape = new TriangleShape();
                break;
        }
        return shape;
    }
}
