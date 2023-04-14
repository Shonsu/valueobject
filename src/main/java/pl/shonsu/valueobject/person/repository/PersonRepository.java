package pl.shonsu.valueobject.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.shonsu.valueobject.person.model.Address;
import pl.shonsu.valueobject.person.model.Email;
import pl.shonsu.valueobject.person.model.NaturalPersonName;
import pl.shonsu.valueobject.person.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p FROM Person p WHERE p.address = :address")
    Optional<Person> findByAddress(@Param("address") Address address);

    Optional<Person> findByEmail(Email email);

    @Query(value = "SELECT p FROM Person p WHERE p.email = :email")
    Optional<Person> findByEmailWithQuery(@Param("email") Email email);

    Optional<Person> findByNaturalPersonName(NaturalPersonName personName);
}
