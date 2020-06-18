package org.example.kvs.application.export;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.UseCase;
import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.example.kvs.port.out.persistence.ExportDataStatisticsPort;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class ExportCustomerInformations implements ExportCustomerInformationsUseCase {

    final LoadCustomerTaskPort loadCustomerTaskPort;
    final ExportDataStatisticsPort exportDataStatisticsPort;

    @Override
    public List<ExportCustomerData> exportCustomerData(LocalDateTime dateTime) {
        List<LoadCustomerTaskPort.LoadCustomerTaskPortModel> customerTaskPortModel = loadCustomerTaskPort.loadCustomerTasksByLastChange(dateTime);
        return customerTaskPortModel.stream().map(this::toMap).collect(Collectors.toList());
    }

    @Override
    public ExportDataStatistics getSchedulerLastExport() {
        return exportDataStatisticsPort.findFirstByOrderByIdDesc() != null ? map(exportDataStatisticsPort.findFirstByOrderByIdDesc()) : null;
    }

    private ExportDataStatistics map(ExportDataStatisticsPort.ExportDataStatisticsPortModel mapTo) {
        return new ExportDataStatistics(mapTo.getLastExport(), mapTo.getNumberOfRecords());
    }

    @Override
    public void saveSchedulerLastExport(ExportDataStatistics exportDataStatistics) {
        exportDataStatisticsPort.save(map(exportDataStatistics));
    }

    private ExportDataStatisticsPort.ExportDataStatisticsPortModel map(ExportDataStatistics mapTo) {
        return new ExportDataStatisticsPort.ExportDataStatisticsPortModel(-1, mapTo.getLastExport(), mapTo.getNumberOfRecords());
    }

    private <R> ExportCustomerData toMap(LoadCustomerTaskPort.LoadCustomerTaskPortModel toMap) {
        return new ExportCustomerData(toMap.getCustomer().getFirmenName(),
                toMap.getCustomer().getStrasse(),
                toMap.getCustomer().getStrassenzusatz(),
                toMap.getCustomer().getOrt(),
                toMap.getCustomer().getLand(),
                toMap.getCustomer().getPlz(),
                toMap.getCustomer().getVorname(),
                toMap.getCustomer().getNachname(),
                toMap.getCustomer().getId());
    }
}
