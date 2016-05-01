package imangazaliev.formvalidator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Поле для проверки валидатором форм
 */
public class FieldValidator {

    private EditText mEditText;
    private TextInputLayout mInputLayout;
    private ArrayList<ValidatePattern> mValidatePatterns;

    public FieldValidator(EditText editText) {
        this(editText, null);
    }

    public FieldValidator(EditText editText, TextInputLayout inputLayout) {
        this.mEditText = editText;
        this.mInputLayout = inputLayout;

        mValidatePatterns = new ArrayList<>();
    }

    public void addPattern(ValidatePattern pattern) {
        mValidatePatterns.add(pattern);
    }

    public boolean validate() {
        ValidatePattern errorPattern = getErrorPattern();
        boolean isValid = (errorPattern == null);
        if (isValid) {
            removeErrors();
        } else {
            showError(getErrorPattern().getMessage());
        }
        return isValid;
    }

    private ValidatePattern getErrorPattern() {
        String text = mEditText.getText().toString();
        for (ValidatePattern pattern : mValidatePatterns) {
            if (!text.matches(pattern.getPattern())) {
                return pattern;
            }
        }
        return null;
    }

    private void showError(String message) {
        if (mInputLayout != null) {
            mInputLayout.setErrorEnabled(true);
            mInputLayout.setError(message);
        } else {
            mEditText.setError(message);
        }
    }

    private void removeErrors() {
        if (mInputLayout != null) {
            mInputLayout.setErrorEnabled(false);
        } else {
            mEditText.setError(null);
        }
    }

}