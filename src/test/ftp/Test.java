package test.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;


public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            String path = "D:/cms.cer";
            FileInputStream fis = new FileInputStream(new File(path));
            long t1 = System.currentTimeMillis();
            System.out.println(FTPUtils.storeFile("192.168.33.1", 21, "taiji", "Qwer1234", "/examples/", "cms.cer" , fis));
//            System.out.println(FTPUtils.retrieveFile("192.168.33.1", 21, "taiji", "Qwer1234", "/examples/", "cms.cer", "d:/app/examples//20200113"));
            long t2 = System.currentTimeMillis();
            System.out.println((t2-t1)/1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(FTPUtils.retrieveFile("192.168.25.144", 21, "zeng", "zeng", "examples", "4.jpg", "D:/"));
//        File file = new File("E:/222.jpg");
//        InputStream is = new FileInputStream(file);

//        System.out.println(FTPUtils.storeFile("127.0.0.1", 21, "zeng", "zeng", "examples", "2.jpg", is));
//        System.out.println(FTPUtils.retrieveFile("127.0.0.1", 21, "feili", "feili", "examples/jsp", "index.html", "C:/Users/freed/Desktop"));
//        System.out.println(FTPUtils.deleteFile("127.0.0.1", 21, "feili", "feili", "testpath", "1.txt"));

    }
}
