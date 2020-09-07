package com.springinaction.chapter3.propeditor;

public class PhoneEditor extends java.beans.PropertyEditorSupport{

    public void setAsText(String textValue) throws IllegalArgumentException {
        String stripped = stripNonNumber(textValue);

        String areaCode = stripped.substring(0, 3);
        String prefix = stripped.substring(3, 6);
        String number = stripped.substring(6);
        PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
        setValue(phone);
    }

    private String stripNonNumber(String original) {
        StringBuffer allNumeric = new StringBuffer();

        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);
            if (Character.isDigit(c)) {
                allNumeric.append(c);
            }
        }

        return allNumeric.toString();
    }
}