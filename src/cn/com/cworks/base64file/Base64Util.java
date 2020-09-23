package cn.com.cworks.base64file;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Base64Util {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("path/img2.jpeg");
        InputStream inputStream = Files.newInputStream(path);
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        String encode = Base64.encode(data);
        System.out.println(encode);
    }


}
