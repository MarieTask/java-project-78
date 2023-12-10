package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStringSchema {
    private static final int RANDOM_INTEGER = 7;
    private static final int WRONG_LENGTH = 25;
    private static final int RIGHT_LENGTH = 5;
    private StringSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.string();
    }

        // Пока не вызван метод required(), null и пустая строка считаются валидным
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("String"));
    }

    @Test
    public void requiredIsValidTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid("String"));
    }

    @Test
    public void firstRequiredMethodsChainTest() {
        schema.required();
        schema.contains("wh");
        assertTrue(schema.isValid("what does the fox say")); // true
        assertFalse(schema.isValid("waat does the fox say")); // false
        assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false
        assertFalse(schema.isValid("what does the fox say")); // false
        // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
        assertTrue(schema.minLength(RIGHT_LENGTH).isValid("whatthe"));
        assertFalse(schema.minLength(WRONG_LENGTH).isValid("whatthe"));
    }
}
