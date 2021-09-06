import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class AscDataFetch {
    public static void main(String[] args) throws Exception {
        File file = new File("");
        file = new File(file.getCanonicalFile()+"/src/test/java/2021-03-10-17-56-02.asc");
//        System.out.println(file);
        FileReader fr = new FileReader(file);
        char[] arr = new char[1024];
        int len = -1;
        int count = 0;
        StringBuilder strBuilder = new StringBuilder();
        String str = "";
        while((len=fr.read(arr))!=-1){
            strBuilder.append(String.valueOf(arr,0,len));
        }
//        System.out.print(strBuilder);
        String[] arrStrs = strBuilder.toString().split("\r\n");
        String[] strs;
        int port;
        String id;
        int length;
        String canData;
        count = 0;
        for (int i = 5; i < arrStrs.length -1; i++) {

            strs = arrStrs[i].split(" ");
            port = Integer.valueOf(strs[1]);
            id = strs[2];
            length = Integer.valueOf(strs[5]);
            canData = "";
            for (int j = 0; j < length; j++) {
                if(j == length - 1){
                    canData += strs[6+j];
                    break;
                }else{
                    canData += strs[6+j] + " ";
                }

            }
            if(id.contains("268") && count<1000){
                count++;
//                00000000,1,0,205,0,0,8,00 1D 68 1D 72 1D 64 63 ,-1,100
//                System.out.println(port + "," + id + "," + length + "," + canData);
                String zeroNum = "";
                for (int k = 0; k < 8 - String.valueOf(count).length(); k++) {
                    zeroNum += "0";
                }
                System.out.println(zeroNum + count + ",1,0," + id + ",0,0," + length + "," + canData + " ,-1,100");
            }
            fr.close();

        }
    }
}
