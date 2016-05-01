package imangazaliev.formvalidator;

import android.support.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * Шаблон для проверки формы на правильность введенных даных
 */
public class ValidatePattern {

    private String mPattern;
    private String mMessage;

    public ValidatePattern(@NonNull String pattern, @NonNull String message) {
        this.mPattern = pattern;
        this.mMessage = message;

        if (!isValidPattern(pattern)) {
            throw new IllegalArgumentException(pattern + " is invalid pattern!");
        }
    }

    private boolean isValidPattern(String pattern) {
        try {
            Pattern.compile(pattern);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getPattern() {
        return mPattern;
    }

    public String getMessage() {
        return mMessage;
    }

}
