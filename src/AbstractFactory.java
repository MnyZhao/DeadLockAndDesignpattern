/**
 * 抽象工厂模式
 * 提供一个创建一系列相关或者相互依赖对象的接口，无需指定他们的类
 */
public class AbstractFactory {
    public static void main(String[] args){
        new GifReaderFactory().getRead().read();
        new JpgReaderFactory().getRead().read();
        new PngReaderFactory().getRead().read();
    }
}

/**
 * 实例
 * 创建一个抽象工厂的接口
 */
interface ReaderFactory {
    Read getRead();
}
class JpgReaderFactory implements ReaderFactory {
    @Override
    public Read getRead() {
        return new readJpg();
    }
}
class GifReaderFactory implements ReaderFactory {
    @Override
    public Read getRead() {
        return new readGif();
    }
}
class PngReaderFactory implements ReaderFactory {
    @Override
    public Read getRead() {
        return new readPng();
    }
}
interface Read {
    void read();
}

class readJpg implements Read {
    @Override
    public void read() {
        System.out.println("readJpg.read");
    }
}

class readGif implements Read {
    @Override
    public void read() {
        System.out.println("readGif.read");
    }
}

class readPng implements Read {
    @Override
    public void read() {
        System.out.println("readPng.read");
    }
}