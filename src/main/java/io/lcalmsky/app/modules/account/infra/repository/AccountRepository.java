package io.lcalmsky.app.modules.account.infra.repository;
	
import io.lcalmsky.app.modules.account.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
    
    boolean existsByPhonenumber(String Phonenumber);
   
    Account findByEmail(String email);
}

