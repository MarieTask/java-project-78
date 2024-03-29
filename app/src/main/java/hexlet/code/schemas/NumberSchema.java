package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super.conditions.add(s -> s instanceof Integer);
    }

    public NumberSchema required() {
        super.setIsRequired();
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> posConditions = s -> s > 0;
        addCondition(posConditions);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> numRange = s -> s >= min && s <= max;
        addCondition(numRange);
        return this;
    }
}
