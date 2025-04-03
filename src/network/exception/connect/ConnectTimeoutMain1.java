package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

// TCP 연결 타임아웃 - OS 기본
public class ConnectTimeoutMain1 {

    //Windows: 약 21초
    //Linux: 약 75초에서 180초 사이, mac test 75초
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket("192.168.1.250", 45678);
        } catch (ConnectException e) {
            //Connection timed out: connect
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Connect time: " + (end - start)); // 21075ms
    }
}
