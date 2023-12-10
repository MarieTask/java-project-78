package hexlet.code;


import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

// класс для отладочной печати
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", v.string().required());
// Возраст должен быть положительным числом
        schemas.put("age", v.number().positive());

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
        schema.shape(schemas);

// Проверяем объекты
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);

        System.out.println(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        System.out.println(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        System.out.println(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        System.out.println(schema.isValid(human4));


    }


}
