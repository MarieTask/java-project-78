package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super.conditions.add(s -> s instanceof Integer);
    }

    public NumberSchema required() {
        super.setIsRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> posConditions = s -> (int) s > 0;
        addCondition(posConditions);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> numRange = s -> (int) s >= min && (int) s <= max;
        addCondition(numRange);
        return this;
    }
}
