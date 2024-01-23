package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super.conditions.add(s -> s instanceof Map);
    }

    public MapSchema required() {
        super.setIsRequired();
        return this;
    }

    public MapSchema sizeof(int countPairs) {
        if (countPairs < 0) {
            throw new IndexOutOfBoundsException("Count of pairs key-value less than zero!");
        }
        super.addCondition(s -> ((Map<?, ?>) s).size() == countPairs);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        map.keySet().forEach(key -> addCondition(s -> map.get(key).isValid(((Map<?, ?>) s).get(key))));
        return this;
    }
}
