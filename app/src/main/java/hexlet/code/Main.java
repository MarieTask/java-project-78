package hexlet.code;


import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

// класс для отладочной печати
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.contains(5).isValid("3635645"));


    }


}
