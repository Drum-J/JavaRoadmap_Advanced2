package io.start;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 3};

        // 메모리에 쓰기
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(input);

        // 메모리에서 읽기
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        byte[] bytes = bis.readAllBytes();
        System.out.println(Arrays.toString(bytes));

        // 메모리에 저장해서 읽고 쓰기 때문에 close()를 하지 않아도 GC 대상이다.
        // 생략가능
        bos.close();
        bis.close();
    }
}
