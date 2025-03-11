package com.pichincha.account.adapter.persistence.postgres.repository;

import com.pichincha.account.adapter.persistence.postgres.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <AccountEntity, Long>{

}
