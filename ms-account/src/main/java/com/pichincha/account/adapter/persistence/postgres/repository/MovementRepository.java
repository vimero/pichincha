package com.pichincha.account.adapter.persistence.postgres.repository;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

}
