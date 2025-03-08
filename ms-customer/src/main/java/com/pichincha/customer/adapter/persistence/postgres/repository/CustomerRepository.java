package com.pichincha.customer.adapter.persistence.postgres.repository;

import com.pichincha.customer.adapter.persistence.postgres.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerEntity, Long>{

}
