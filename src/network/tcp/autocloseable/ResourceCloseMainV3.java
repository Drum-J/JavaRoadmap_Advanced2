package network.tcp.autocloseable;

public class ResourceCloseMainV3 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException 최종적으로 반환
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally { // finally 자원 정리 중에 발생하는 예외를 잡아서 처리해보자!
            if (resource2 != null) {
                try {
                    resource2.closeEx(); // CloseException 발생!
                } catch (CloseException e) {
                    // close()에서 발생한 예외는 버린다. 필요하면 로깅 정도
                    System.out.println("close ex: " + e);
                }

            }

            if (resource1 != null) {
                try {
                    resource1.closeEx(); // 이제 호출 됨!
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }

            }
        }
    }
}
