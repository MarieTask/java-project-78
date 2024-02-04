package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected final List<Predicate<T>> conditions;
    private Boolean isRequired = false;

    protected BaseSchema() {
        this.conditions = new LinkedList<>();
    }

    //Indicates if the specified attribute is required
    protected final void setIsRequired() {
        this.isRequired = Boolean.TRUE;
    }
    protected final void addCondition(Predicate<T> condition) {
        conditions.add(condition);
    }
    public boolean isValid(T obj) {
        if (!isRequired && !(conditions.get(0).test(obj))) {
            System.out.println(conditions.get(0));
            return true;
        }
        return conditions.stream().allMatch(condition -> condition.test(obj));
    }
}
