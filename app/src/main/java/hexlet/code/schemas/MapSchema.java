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
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        schemas.keySet().forEach(key -> super.addCondition(s -> schemas.get(key).isValid((T) s.get(key))));
        return this;
    }
}
