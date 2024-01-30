package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class StringSchema<T> extends BaseSchema<T> {

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
        Predicate<T> stringLength = s -> ((String) s).length() >= userNumber;
        super.addCondition(stringLength);
        return this;
    }

    public StringSchema contains(String userData) {
        Predicate<T> containsString = s -> ((String) s).contains(userData);
        super.addCondition(containsString);
        return this;
    }
}
