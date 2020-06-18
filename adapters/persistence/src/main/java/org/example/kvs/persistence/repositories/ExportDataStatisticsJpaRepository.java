package org.example.kvs.persistence.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.sql.Timestamp;

public interface ExportDataStatisticsJpaRepository extends JpaRepository<ExportDataStatisticsJpaRepository.ExportDataStatisticsJpaEntity, Integer> {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = "EXPORTDATASTATISTICS")
    @Entity
    @SequenceGenerator(name = "SEQ_EXPORT_DATA_STATISTICS_GEN", sequenceName = "SEQ_EXPORT_DATA_STATISTICS")
    class ExportDataStatisticsJpaEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXPORT_DATA_STATISTICS_GEN")
        int id;
        @Column(name = "LASTEXPORT")
        Timestamp lastExport;
        @Column(name = "NUMBEROFRECORDS")
        int numberOfRecords;
    }

    ExportDataStatisticsJpaEntity findFirstByOrderByIdDesc();
}
