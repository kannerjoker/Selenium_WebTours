import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ExtendedFrame {
    public static void main(String[] args) throws Exception {
        String fileName = "2021-03-10-17-56-02.asc";
        File file = new File("");
        file = new File(file.getCanonicalFile()+"/src/test/java/" + fileName);
        FileReader fr = new FileReader(file);
        char[] arr = new char[1024];
        int num = -1;
        StringBuilder stringBuilder = new StringBuilder(1024);
        while((num=fr.read(arr))!=-1){
            stringBuilder.append(String.valueOf(arr,0,num));
        }
//        System.out.println(stringBuilder);
        String[] dataLanes = stringBuilder.toString().split("\r\n");
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(dataLanes.length);
        String[] strs;
        for (int i = 5; i < dataLanes.length - 1; i++) {
            strs = dataLanes[i].split(" RX ");
            arrayList.add(strs[0] + "x RX " + strs[1]);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("date Wen Mar 10 05:56:02:310000 PM 2021\n" +
                "base hex timestamps absolute\n" +
                "internal events logged\n" +
                "Begin Triggerblock PM 2021\n" +
                "0.000000 Start of measurement\r\n");
//        System.out.println(stringBuilder);
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(arrayList.get(i) + "\r\n");
        }
        stringBuilder.append("End TriggerBlock");
//        System.out.println(stringBuilder);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getParentFile()+ "/" + fileName.split("\\.")[0]+"_x.asc"));
        bw.write(stringBuilder.toString());
        bw.close();
    }
}
