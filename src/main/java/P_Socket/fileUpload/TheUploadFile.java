package P_Socket.fileUpload;

import java.io.Serializable;
import java.util.ArrayList;

public class TheUploadFile implements Serializable {
    public static final long serialVersionUID = 101;
    static String fileName;
    static String filePath;
    static ArrayList<String> fileNames;
    static transient ArrayList<String> filePaths;
}
