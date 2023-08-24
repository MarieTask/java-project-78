package hexlet.code.schemas;

import hexlet.code.MinLength;
import hexlet.code.NotNull;
import hexlet.code.Value;

public class StringSchema extends BaseSchema{

    private boolean isRequired;
    private boolean isContains;
    private String content;
    private int stringLength;

    @NotNull
    public StringSchema required() {
        isRequired = true;
        return this;
    }

    @MinLength
    public StringSchema minLength(int minLength) {
        stringLength = minLength;
        return this;
    }

    @Value
    public StringSchema contains(String substring) {
        isContains = content.contains(substring);
            return this;
        }

    public boolean isValid(Object content) {
        if (isRequired && content == null) {
            return false;
        }
        if (content != null && content.toString().length() < stringLength) {
            return false;
        }
        if (content != null && !isContains) {
            return false;
        }
        return true;
    }
}
