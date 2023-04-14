package pl.shonsu.valueobject.person.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import pl.shonsu.valueobject.person.model.Address;

@Converter
public class AddressConverter implements AttributeConverter<Address, String> {

    public static final String SERPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Address attribute) {
        if (attribute == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!attribute.city().isEmpty() &&
                        !attribute.street().isEmpty() &&
                        attribute.number() != null
        ) {
            sb.append(attribute.city());
            sb.append(SERPARATOR);
            sb.append(attribute.street());
            sb.append(SERPARATOR);
            sb.append(attribute.number());
        }
        return sb.toString();
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        String[] pieces = dbData.split(SERPARATOR);
        if (pieces.length == 0) {
            return null;
        }
        return new Address(pieces[0], pieces[1], Integer.valueOf(pieces[2]));
    }
}
