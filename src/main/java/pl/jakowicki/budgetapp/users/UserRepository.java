package pl.jakowicki.budgetapp.users;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);
}
