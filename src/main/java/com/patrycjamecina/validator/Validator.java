package com.patrycjamecina.validator;
import com.patrycjamecina.constant.ImageryType;
import com.patrycjamecina.exceptions.VariableException;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
public class Validator {
    public static void validateName(String name) {
        if (StringUtils.isEmpty(name) || StringUtils.isNumeric(name) || !name.chars().allMatch(Character::isLetter)) {
            throw new VariableException();
        }
    }

    public static void validateType(String type) {
        if (StringUtils.isEmpty(type) || !EnumUtils.isValidEnum(ImageryType.class, type.toUpperCase())) {
            throw new VariableException();
        }
    }
}
