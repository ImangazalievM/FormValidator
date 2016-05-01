package imangazaliev.formvalidator;

import java.util.ArrayList;

/**
 * Валидатор форм
 */
public class FormValidator {

    private ArrayList<FieldValidator> mFields;

    public FormValidator() {
        mFields = new ArrayList<>();
    }

    /**
     * Добавляет поле в форму
     */
    public void addField(FieldValidator field) {
        mFields.add(field);
    }

    /**
     * Проверяет все поля на валидность
     */
    public boolean validate() {
        for (FieldValidator field: mFields) {
            if (!field.validate()) {
                return false;
            }
        }
        return true;
    }

}
