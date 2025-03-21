package io.start;

import java.io.IOException;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;

        byte[] bytes = "Hello!\n".getBytes(UTF_8);
        printStream.write(bytes);
        printStream.println("Print!");

        // 이것도 마찬가지로 콘솔에 출력하기 때문에 close() 를 호출하지 않아도 상관없다.
        printStream.close();
    }
}
