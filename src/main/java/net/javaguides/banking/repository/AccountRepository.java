package net.javaguides.banking.repository;
import net.javaguides.banking.entity.Account;

import net.javaguides.banking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
