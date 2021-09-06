package P_Socket.P_SocketWeb;

import java.io.File;
import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        try {
            System.out.println(new File("./").getCanonicalFile().getParentFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
