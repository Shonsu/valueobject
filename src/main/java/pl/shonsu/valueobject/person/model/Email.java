package pl.shonsu.valueobject.person.model;

import org.springframework.util.Assert;

public record Email(String value) {

    public static Email of(String value) {
        Assert.hasText(value, "value should have text");
        return new Email(value);
    }

    public String getValue() {
        return value;
    }
}
