package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

// класс для отладочной печати
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        System.out.println(schema.positive().isValid(null));
        System.out.println(schema.positive().required().isValid(null));
        System.out.println(schema.required().positive().isValid(null));
        System.out.println(schema.required().isValid(null));

    }


}
