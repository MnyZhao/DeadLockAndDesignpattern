public class MyBuilder {
    private int id;
    private String num;

    public MyData build() {
        MyData d = new MyData();
        d.setId(id);
        d.setNum(num);
        return d;
    }

    public MyBuilder setId(int id) {
        this.id = id;
        return this;
    }
    public int getId(){
        return id;
    }
    public String getNum(){
        return num;
    }

    public MyBuilder setNum(String num) {
        this.num = num;
        return this;
    }

    public static void main(String[] args) {
        MyBuilder builder=new MyBuilder();
        builder.setId(10).setNum("50");
        MyData data=builder.build();
        System.out.println("MyBuilder.main"+"id:"+data.getId()+" num:"+data.getNum());
    }

}

class MyData {
    private int id;
    private String num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
