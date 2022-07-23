package com.billing.installcustomerws.repository.postgre;

import com.billing.installcustomerws.entity.postgre.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
    @Query(value = "SELECT last_value FROM customer_sequence", nativeQuery = true)
    Long getSequenceLastValue();
}
