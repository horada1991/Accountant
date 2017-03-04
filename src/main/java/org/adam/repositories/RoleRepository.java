package org.adam.repositories;

import org.adam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
