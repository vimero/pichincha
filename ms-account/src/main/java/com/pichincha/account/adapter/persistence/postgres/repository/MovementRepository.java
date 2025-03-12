package com.pichincha.account.adapter.persistence.postgres.repository;

import com.pichincha.account.adapter.persistence.postgres.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

    List<MovementEntity> findByAccountId(Long accountId);

    List<MovementEntity> findByAccountIdAndDateBetween(Long accountId, LocalDateTime from, LocalDateTime to);

    @Query("SELECT m FROM MovementEntity m WHERE m.account.customer = :customerId AND m.date BETWEEN :from AND :to")
    List<MovementEntity> findByCustomerIdAndDateBetween(Long customerId, LocalDateTime from, LocalDateTime to);

    @Query(value = "SELECT jsonb_build_object(" +
            "'customerId', a.customer, " +
            "'accounts', jsonb_agg(" +
            "   jsonb_build_object(" +
            "       'accountId', a.id, " +
            "       'numeroCuenta', a.number, " +
            "       'movements', (" +
            "           SELECT jsonb_agg(" +
            "               jsonb_build_object(" +
            "                   'movementId', m.id, " +
            "                   'fecha', to_char(m.date, 'YYYY-MM-DD HH24:MI:SS'), " +
            "                   'balance', m.balance, " +
            "                   'amount', m.amount, " +
            "                   'type', " +
            "                   CASE " +
            "                       WHEN m.type = 0 THEN 'DEPOSIT' " +
            "                       WHEN m.type = 1 THEN 'WITHDRAWAL' " +
            "                       ELSE 'UNKNOWN' " +
            "                   END" +
            "               )" +
            "           ) FROM movement m WHERE m.account = a.id AND m.date BETWEEN :from AND :to " +
            "       )" +
            "   )" +
            "))::jsonb AS result " +
            "FROM account a " +
            "WHERE a.customer = :customerId " +
            "GROUP BY a.customer;",
            nativeQuery = true)
    Map<String, Object> findByCustomerIdAndDateBetweenJson(@Param("customerId") Long customerId,
                                                           @Param("from") LocalDateTime from,
                                                           @Param("to") LocalDateTime to);

}
