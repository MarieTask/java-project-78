package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapSchema {
    private MapSchema schema;
    private static final int MIN_LENGTH = 3;
    private static final int MIN = 18;
    private static final int MAX = 35;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.map();
    }

    // Пока не вызван метод required(), null и пустая строка считаются валидным
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(1));
    }

    @Test
    public void requiredIsValidTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(1));
    }

    @Test
    public void firstRequiredMethodsChainTest() {
        schema.required();
        assertTrue(schema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void shapeTest1() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", Validator.string().required());
        schemas.put("age", Validator.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(schema.isValid(human4));
    }

    @Test
    public void shapeTest2() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", Validator.string().minLength(MIN_LENGTH));
        schemas.put("age", Validator.number().range(MIN, MAX).required());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertFalse(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", MIN_LENGTH);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", 25);
        assertTrue(schema.isValid(human4));
    }

    @Test
    public void testValid() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        assertTrue(schema.isValid(null));
    }
}
