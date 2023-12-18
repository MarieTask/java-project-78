package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        super.setIsRequired();
        Predicate<Object> numConditions = s -> s instanceof Integer;
        addCondition(numConditions);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> posConditions = s -> (Objects.equals(s, null)) || (int) s > 0;
        addCondition(posConditions);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> numRange = s -> (int) s >= min && (int) s <= max;
        addCondition(numRange);
        return this;
    }
}
