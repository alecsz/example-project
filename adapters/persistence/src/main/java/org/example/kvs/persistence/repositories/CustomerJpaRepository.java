package org.example.kvs.persistence.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public interface CustomerJpaRepository extends JpaRepository<CustomerJpaRepository.CustomerJpaEntity, Integer> {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = "KUNDE")
    @Entity
    class CustomerJpaEntity {
        @Id
        @Column(name = "KUNDENID")
        int id;
        @Column(name = "VORNAME")
        String vorname;
        @Column(name = "NACHNAME")
        String nachname;
        @Column(name = "EMAIL")
        String email;
        @Column(name = "STRASSE")
        String strasse;
        @Column(name = "STRASSENZUSATZ")
        String strassenzusatz;
        @Column(name = "ORT")
        String ort;
        @Column(name = "LAND")
        String land;
        @Column(name = "PLZ")
        String plz;
        @Column(name = "FIRMENNAME")
        String firmenName;
    }
}
