package network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

// TCP 연결 타임아웃 - 직접 설정
public class ConnectTimeoutMain2 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.150", 45678), 10000);
            // timeout 설정
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Connect time: " + (end - start)); // 10016ms -> 설정한 시간만큼 연결 시도
    }
}
