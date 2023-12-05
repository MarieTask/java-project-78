package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.function.Predicate;

public abstract class BaseSchema {
    //LinkedList обеспечивает добавление условий в порядке, требуемым пользователем
    private final LinkedList<Predicate<Object>> conditions = new LinkedList<>();
    protected final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public final boolean isValid(Object obj) {
        return conditions.stream()
                .allMatch(condition -> condition.test(obj));
    }
}
