package org.example.kvs.persistence.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface CustomerTaskJpaRepository extends JpaRepository<CustomerTaskJpaRepository.CutomerTaskJpaEntity, String> {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = "AUFTRAEGE")
    @Entity
    class CutomerTaskJpaEntity {
        @Id
        @Column(name = "AUFTRAGID")
        String id;
        @Column(name = "ARTIKELNUMMER")
        String artikelNummer;
        @Column(name = "CREATED")
        Timestamp created;
        @Column(name = "LASTCHANGE")
        Timestamp lastChange;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "KUNDEID")
        CustomerJpaRepository.CustomerJpaEntity customer;
    }

    List<CustomerTaskJpaRepository.CutomerTaskJpaEntity> findByLastChangeGreaterThan(Timestamp date2);
}
