package USB_Interface;

public class Notebook_Computer {
    public void powerOn(){
        System.out.println("笔记本开机");
    }
    public void powerOff(){
        System.out.println("笔记本关机");
    }
    //使用接口作为方法参数
    public void useDevice(USB_Interface usb){
        usb.open();
        if(usb instanceof Mouse){
            Mouse m = (Mouse)usb;
            m.click();
        }else if(usb instanceof Keyboard){
            Keyboard k = (Keyboard)usb;
            k.type();
        }
        usb.close();
    }

    public static void main(String[] args) {
        Notebook_Computer n = new Notebook_Computer();
        n.powerOn();
        USB_Interface usbMouse = new Mouse();
        n.useDevice(usbMouse);
        System.out.println("=============================");
        USB_Interface usbKeyboard = new Keyboard();
        n.useDevice(usbKeyboard);


        n.powerOff();

    }
}
