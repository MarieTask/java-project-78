package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestMapSchema {
    private MapSchema schema;
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 100;
    private static final int IN_RANGE = 25;
    private static final int NEGATIVE = -5;
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
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    public void requiredIsValidTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
    }

    @Test
    public void firstRequiredMethodsChainTest() {
        schema.required();
        assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public <T> void shapeTest1() {
        Map<String, BaseSchema<T>> schemas = new HashMap<>();
        schemas.put("name", (BaseSchema<T>) Validator.string().required());
        schemas.put("age", (BaseSchema<T>) Validator.number().range(MIN, MAX));

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", MAX_LENGTH);
        assertFalse(schema.isValid(human1));

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
        human4.put("age", NEGATIVE);
        assertFalse(schema.isValid(human4));

        Map<String, Object> human5 = new HashMap<>();
        human5.put("name", " ");
        human5.put("age", IN_RANGE);
        assertTrue(schema.isValid(human5));
    }

    @Test
    public <T> void shapeTest2() {
        Map<String, BaseSchema<T>> schemas = new HashMap<>();
        schemas.put("name", (BaseSchema<T>) Validator.string().minLength(MIN_LENGTH));
        schemas.put("age", (BaseSchema<T>) Validator.number().range(MIN, MAX).required());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", MAX_LENGTH);
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
        human4.put("age", IN_RANGE);
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
