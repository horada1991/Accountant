package org.adam.repositories;

import org.adam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cerianth on 2017.02.06..
 */
public interface RoleRepository extends JpaRepository<User, String> {
}
