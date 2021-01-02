package com.sammidev.validator;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

// NOT IMPLEMENTED
@Component
public class PhoneNumberValidator implements Predicate<String> {

    private static final Predicate<String> IS_PHONENUMBER_VALID = Pattern.compile("^\\d{14}$").asPredicate();

    @Override
    public boolean test(String phoneNumber) {
        return phoneNumber.startsWith("08") && IS_PHONENUMBER_VALID.test(phoneNumber);
    }
}