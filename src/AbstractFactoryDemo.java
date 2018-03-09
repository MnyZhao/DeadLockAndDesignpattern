import com.sun.javafx.iio.ios.IosDescriptor;
import com.sun.org.apache.xpath.internal.operations.And;

/*实例：
　　现在需要做一款跨平台的游戏，需要兼容Android，Ios，Wp三个移动操作系统，
该游戏针对每个系统都设计了一套操作控制器（OperationController）和界面控制器（UIController），
下面通过抽闲工厂方式完成这款游戏的架构设计。*/
public class AbstractFactoryDemo {
    public static void main(String[] args){
        new AndroidFactory().getOperationController().control();
        new AndroidFactory().getUIController().display();
        new IOSFactory().getOperationController().control();
        new IOSFactory().getUIController().display();
        new WPFactory().getOperationController().control();
        new WPFactory().getUIController().display();
    }
}

interface OperationCOntroller {
    void control();
}
interface UIController {
    void display();
}

class AndroidOperationController implements OperationCOntroller {

    @Override
    public void control() {
        System.out.println("AndroidOperationController.control");
    }
}

class AndroidUIController implements UIController {

    @Override
    public void display() {
        System.out.println("AndroidUIController.display");
    }
}

class IOSOperationController implements OperationCOntroller {

    @Override
    public void control() {
        System.out.println("IOSOperationController.control");
    }
}

class IOSUIController implements UIController {

    @Override
    public void display() {
        System.out.println("IOSUIController.display");
    }
}

class WPOperationController implements OperationCOntroller {

    @Override
    public void control() {
        System.out.println("WPOperationController.control");
    }
}

class WPUIController implements UIController {

    @Override
    public void display() {
        System.out.println("WPUIController.display");
    }
}

interface Controller{
    OperationCOntroller getOperationController();
    UIController getUIController();
}
class AndroidFactory implements Controller{

    @Override
    public OperationCOntroller getOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public UIController getUIController() {
        return new AndroidUIController();
    }
}
class IOSFactory implements Controller{

    @Override
    public OperationCOntroller getOperationController() {
        return new IOSOperationController();
    }

    @Override
    public UIController getUIController() {
        return new IOSUIController();
    }
}
class WPFactory implements Controller{

    @Override
    public OperationCOntroller getOperationController() {
        return new WPOperationController();
    }

    @Override
    public UIController getUIController() {
        return new WPUIController();
    }
}