package pl.shonsu.valueobject.person.model;

import jakarta.persistence.*;
import pl.shonsu.valueobject.person.model.converter.AddressConverter;
import pl.shonsu.valueobject.person.model.converter.EmailConverter;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private NaturalPersonName naturalPersonName;
    @Convert(converter = EmailConverter.class)
    private Email email;
    @Convert(converter = AddressConverter.class)
    private Address address;

    protected Person() {
    }

    public Person(Long id, NaturalPersonName naturalPersonName, Email email, Address address) {
        this.id = id;
        this.naturalPersonName = naturalPersonName;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public NaturalPersonName getNaturalPersonName() {
        return naturalPersonName;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

}
