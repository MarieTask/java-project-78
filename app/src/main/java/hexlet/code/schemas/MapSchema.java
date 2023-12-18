package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        super.setIsRequired();
        Predicate<Object> mapConditions = s -> s instanceof Map;
        addCondition(mapConditions);
        return this;
    }

    public MapSchema sizeof(int countPairs) {
        if (countPairs < 0) {
            throw new IndexOutOfBoundsException("Count of pairs key-value less than zero!");
        }
        Predicate<Object> countOfPairs = s -> ((Map<?, ?>) s).size() == countPairs;
        addCondition(countOfPairs);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        map.keySet().forEach(key -> addCondition(s -> map.get(key).isValid(((Map<?, ?>) s).get(key))));
        return this;
    }
}
