package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        super.setIsRequired();
        Predicate<Object> strConditions = s -> !(Objects.equals(s, "")) && s instanceof String;
        addCondition(strConditions);
        return this;
    }

    public StringSchema minLength(int userNumber) {
        if (userNumber < 0) {
            throw new IndexOutOfBoundsException("Index less than zero!");
        }
        Predicate<Object> stringLength = s -> ((String) s).length() >= userNumber;
        addCondition(stringLength);
        return this;
    }

    public StringSchema contains(String userData) {
        Predicate<Object> containsString = s -> ((String) s).contains(userData);
        addCondition(containsString);
        return this;
    }
}
