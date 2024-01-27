package hexlet.code.schemas;

import java.util.Map;

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
        map.keySet().forEach(key -> super.addCondition(s -> map.get(key).isValid(((Map<?, ?>) s).get(key))));
        return this;
    }
}
