import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File(new File("").getCanonicalFile() + "/src/test/java/idaf-models.txt");
        System.out.println(file);

        /*FileInputStream fis = new FileInputStream(file);
        byte[] arrBytes = new byte[1024];
        int num = 0;
        while((num=fis.read(arrBytes))!=-1){
            String str = new String(arrBytes,0,num);
        }
        System.out.println("-----------------------------");*/


        /*BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while((str=br.readLine())!=null){
            System.out.println(str);
        }*/

        FileReader fr = new FileReader(file);
        char[] arrChars = new char[1024*16];
        ArrayList<String> arrString = new ArrayList();
        int num = -1;
        while((num = fr.read(arrChars))!=-1){
            arrString.add(String.valueOf(arrChars,0,num));
        }
        ArrayList<String[]> arrListString = new ArrayList();
        for (int i = 0; i < arrString.size(); i++) {
            arrListString.add(arrString.get(i).split("(<option value=)|(selected=\"selected\" title=)|(title=)|(data-keys=)|(>/.*</option>)"));
//            System.out.println(i + " ----> " + Arrays.toString(arrListString.get(i)));
        }
        String[] strs = null;
        strs = arrListString.get(0);
        for (int i = 0; i < strs.length; i++) {
            if(i%4 == 0 && i>=4){
//                System.out.println("---->" + i);
                System.out.println(strs[i-2].substring(1,strs[i-2].length()-2) + "/(#" + strs[i-3].substring(1,strs[i-3].length()-2) + ")");

            }
        }
    }
}
