package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

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
        super.addCondition(s -> s.size() == countPairs);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> map) {
        map.keySet().forEach(key -> super.addCondition(s -> map.get(key).isValid((String) s.get(key))));
        return this;
    }
}
