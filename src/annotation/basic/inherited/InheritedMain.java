package annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {
    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class); // 클래스는 InheritedAnnotation 상속
        print(TestInterface.class);
        print(TestInterfaceImpl.class); // 인터페이스 구현체는 애노테이션 상속 안됨
    }

    private static void print(Class<?> clazz) {
        System.out.println("class: " + clazz);
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(" - " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
