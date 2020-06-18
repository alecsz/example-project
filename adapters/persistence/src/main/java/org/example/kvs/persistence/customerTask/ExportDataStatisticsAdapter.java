package org.example.kvs.persistence.customerTask;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.PersistenceAdapter;
import org.example.kvs.persistence.repositories.ExportDataStatisticsJpaRepository;
import org.example.kvs.port.out.persistence.ExportDataStatisticsPort;

import java.sql.Timestamp;


@RequiredArgsConstructor
@PersistenceAdapter
class ExportDataStatisticsAdapter implements ExportDataStatisticsPort {

    final ExportDataStatisticsJpaRepository exportDataStatisticsJpaRepository;


    @Override
    public ExportDataStatisticsPortModel findFirstByOrderByIdDesc() {
        return exportDataStatisticsJpaRepository.findFirstByOrderByIdDesc() != null ? map(exportDataStatisticsJpaRepository.findFirstByOrderByIdDesc()) : null;
    }

    private ExportDataStatisticsPortModel map(ExportDataStatisticsJpaRepository.ExportDataStatisticsJpaEntity mapTo) {
        return new ExportDataStatisticsPortModel(mapTo.getId(), mapTo.getLastExport().toLocalDateTime(), mapTo.getNumberOfRecords());
    }

    @Override
    public void save(ExportDataStatisticsPortModel exportDataStatisticsPortModel) {
        exportDataStatisticsJpaRepository.save(map(exportDataStatisticsPortModel));
    }

    private ExportDataStatisticsJpaRepository.ExportDataStatisticsJpaEntity map(ExportDataStatisticsPortModel mapTo) {
        return new ExportDataStatisticsJpaRepository.ExportDataStatisticsJpaEntity(-1, Timestamp.valueOf(mapTo.getLastExport()), mapTo.getNumberOfRecords());
    }
}
