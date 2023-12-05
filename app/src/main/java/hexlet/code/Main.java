package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

// класс для отладочной печати
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        System.out.println(schema.required().isValid("5"));

    }


}
