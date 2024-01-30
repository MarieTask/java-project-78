package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestNumberSchema {
    private static final int RANDOM_INTEGER = 7;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int LESS_ZERO = -5;
    private static final int ZERO = 0;
    private NumberSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = Validator.number();
    }

    // Пока не вызван метод required(), null считаeтся валидным
    @Test
    public void beforeRequiredTest() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void requiredIsValidTest() {
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(LESS_ZERO));
    }

    @Test
    public void requiredMethodsChainTest() {
        schema.positive();
        assertTrue(schema.isValid(null));
        schema.required();
        assertTrue(schema.isValid(RANDOM_INTEGER));
        // Потому что ранее мы вызвали метод positive()
        assertFalse(schema.isValid(LESS_ZERO));
        //  Ноль — не положительное число
        assertFalse(schema.isValid(ZERO));
        schema.range(MIN_LENGTH, MAX_LENGTH);
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertFalse(schema.isValid(ZERO));
    }

    @Test
    public void testValid() {
        schema.positive();
        assertTrue(schema.isValid(RANDOM_INTEGER));
        assertTrue(schema.isValid(null));
    }
}
