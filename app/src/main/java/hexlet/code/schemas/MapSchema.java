package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        Predicate<Object> mapConditions = s -> s instanceof Map;
        addCondition(mapConditions);
        return this;
    }

    public MapSchema sizeOf(int countPairs) {
        if (countPairs < 0) {
            throw new IndexOutOfBoundsException("Count of pairs key-value less than zero!");
        }
        Predicate<Object> countOfPairs = s -> ((Map<?, ?>) s).size() == countPairs;
        addCondition(countOfPairs);
        return this;
    }
}
