package annotation.java;

public class OverrideMain {

    static class A {
        public int x = 1;

        public void call() {
            System.out.println("A.call");
        }

        public int getX() {
            return x;
        }
    }

    static class B extends A {

        public int x = 3;

        @Override
        public void call() {
            System.out.println("B.call");
        }

        @Override
        public int getX() {
            return x;
        }
    }

    public static void main(String[] args) {
        A a = new B();
        a.call();

        System.out.println("getX() = " + a.getX());
        System.out.println("a.x = " + a.x);
    }
}
