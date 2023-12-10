package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMapSchema {
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.map();
    }

    // Пока не вызван метод required(), null и пустая строка считаются валидным
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));
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
        schema.sizeOf(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
}
