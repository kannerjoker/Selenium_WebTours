package javaStream;

public class DemoReference {
    public static void main(String[] args) {
        DemoReference dr = new DemoReference();
        dr.printWords(dr::printUpper);
    }

    public void printWords(Printable printable){
        printable.print("hello");
    }
    public void printUpper(String s){
        System.out.println(s.toUpperCase());
    }
    public void demoPrint(){
        printWords(this::printUpper);
    }
}
