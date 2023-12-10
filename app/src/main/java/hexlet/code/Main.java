package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import static java.lang.String.valueOf;

// класс для отладочной печати
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.contains("1").isValid("48285"));


    }


}
