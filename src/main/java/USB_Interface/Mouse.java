package USB_Interface;

public class Mouse implements USB_Interface{
    @Override
    public void open(){
        System.out.println("打开USB设备-鼠标");
    }
    @Override
    public void close(){
        System.out.println("关闭USB设备-鼠标");
    }
    public void click(){
        System.out.println("鼠标点击");
    }
}
