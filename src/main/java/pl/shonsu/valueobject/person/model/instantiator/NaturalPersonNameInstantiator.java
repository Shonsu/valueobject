package pl.shonsu.valueobject.person.model.instantiator;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.EmbeddableInstantiator;
import org.hibernate.metamodel.spi.ValueAccess;
import pl.shonsu.valueobject.person.model.Address;
import pl.shonsu.valueobject.person.model.NaturalPersonName;

public class NaturalPersonNameInstantiator implements EmbeddableInstantiator {
    @Override
    public Object instantiate(ValueAccess valueAccess, SessionFactoryImplementor sessionFactoryImplementor) {
        String firstName = valueAccess.getValue(0, String.class);
        String lastName = valueAccess.getValue(0, String.class);
        return new NaturalPersonName(firstName, lastName);
    }

    @Override
    public boolean isInstance(Object o, SessionFactoryImplementor sessionFactoryImplementor) {
        return o instanceof NaturalPersonName;
    }

    @Override
    public boolean isSameClass(Object o, SessionFactoryImplementor sessionFactoryImplementor) {
        return o.getClass().equals(Address.class);
    }
}
