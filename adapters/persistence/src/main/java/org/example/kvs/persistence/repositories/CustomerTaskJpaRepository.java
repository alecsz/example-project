package org.example.kvs.persistence.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.math.BigDecimal;

public interface CustomerTaskJpaRepository extends JpaRepository<CustomerTaskJpaRepository.CutomerTaskJpaEntity, BigDecimal> {

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
        String created;
        @Column(name = "LASTCHANGE")
        String lastChange;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "KUNDENID")
        CustomerJpaRepository.CustomerJpaEntity customer;
    }
}
