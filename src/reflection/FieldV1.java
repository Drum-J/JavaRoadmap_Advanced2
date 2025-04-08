package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("===== fields() =====");
        Field[] fields = helloClass.getFields(); // 상속 받은 모든 public field
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("===== declaredFields() =====");
        Field[] declaredFields = helloClass.getDeclaredFields(); // 내가 선언한 모든 field
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
