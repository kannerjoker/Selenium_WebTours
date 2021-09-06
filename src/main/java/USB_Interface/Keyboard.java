package USB_Interface;

public class Keyboard implements USB_Interface{
    @Override
    public void open(){
        System.out.println("打开USB设备-键盘");
    }
    @Override
    public void close(){
        System.out.println("关闭USB设备-键盘");
    }
    public void type(){
        System.out.println("键盘打字");
    }

}
