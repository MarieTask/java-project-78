package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super.conditions.add(s -> !(Objects.equals(s, "")) && s instanceof String);
    }

    public StringSchema required() {
        super.setIsRequired();
        return this;
    }

    public StringSchema minLength(int userNumber) {
        if (userNumber < 0) {
            throw new IndexOutOfBoundsException("Index less than zero!");
        }
        Predicate<Object> stringLength = s -> ((String) s).length() >= userNumber;
        super.addCondition(stringLength);
        return this;
    }

    public StringSchema contains(String userData) {
        Predicate<Object> containsString = s -> ((String) s).contains(userData);
        super.addCondition(containsString);
        return this;
    }
}
