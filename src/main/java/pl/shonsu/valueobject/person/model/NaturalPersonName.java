package pl.shonsu.valueobject.person.model;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.EmbeddableInstantiator;
import pl.shonsu.valueobject.person.model.instantiator.NaturalPersonNameInstantiator;

@Embeddable
@EmbeddableInstantiator(NaturalPersonNameInstantiator.class)
public record NaturalPersonName(String firstName, String LastName) {
    NaturalPersonName() {
        this(null,null);
    }
}
