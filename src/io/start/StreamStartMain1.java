package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        fos.write(65); // "A"
        fos.write(66); // "B"
        fos.write(67); // "C"

        fos.close(); // 외부 자원은 사용 후 반드시 닫아주어야 한다.

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read()); // 65
        System.out.println(fis.read()); // 66
        System.out.println(fis.read()); // 67
        System.out.println(fis.read()); // -1 -> 파일 내용 끝

        fis.close(); // 외부 자원은 사용 후 반드시 닫아주어야 한다.
    }
}
