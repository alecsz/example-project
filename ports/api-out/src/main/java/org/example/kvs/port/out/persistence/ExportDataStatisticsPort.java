package org.example.kvs.port.out.persistence;

import lombok.Value;

import java.time.LocalDateTime;

public interface ExportDataStatisticsPort {

    @Value
    class ExportDataStatisticsPortModel {
        int id;
        LocalDateTime lastExport;
        int numberOfRecords;
    }

    ExportDataStatisticsPortModel findFirstByOrderByIdDesc();
    void save(ExportDataStatisticsPortModel exportDataStatisticsPortModel);
}
