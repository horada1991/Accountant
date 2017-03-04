package org.adam.repositories;

import org.adam.model.BankRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BankRollRepository extends JpaRepository<BankRoll, Integer> {
}
