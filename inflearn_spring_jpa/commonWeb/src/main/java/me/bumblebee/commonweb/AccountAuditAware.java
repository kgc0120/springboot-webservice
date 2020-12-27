package me.bumblebee.commonweb;

import me.bumblebee.commonweb.post.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
// AccountAuditAware -> bean 으로는 accountAuditAware 이렇게 등록된다.
public class AccountAuditAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        System.out.println("looking for current user");
        return Optional.empty();
    }
}
