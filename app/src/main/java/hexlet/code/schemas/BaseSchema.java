package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> conditions = new LinkedList<>();
    private Boolean isRequired = Boolean.FALSE;

    //Indicates if the specified attribute is required
    protected final void setIsRequired() {
        this.isRequired = Boolean.TRUE;
    }
    protected final void addCondition(Predicate<Object> condition) {
        conditions.add(condition);
    }
    public final boolean isValid(Object obj) {
        if (obj == null) {
            return !isRequired;
        }
        if (!conditions.stream().allMatch(condition -> condition.test(obj))) {
            return false;
        }
        return true;
    }
}
