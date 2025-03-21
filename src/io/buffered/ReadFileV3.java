package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int size;
        while ((size = bis.read()) != -1) { // bis에서 읽고
            fileSize++;
        }
        bis.close(); // bis에서 닫아야한다.

        long endTime = System.currentTimeMillis();

        System.out.println("File create: " + FILE_NAME);
        System.out.println("File size: " + (fileSize / 1024 / 1024) + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms"); // 145ms
    }
}
