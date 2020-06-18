package org.example.kvs.application.export;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.UseCase;
import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
public class ExportCustomerInformations implements ExportCustomerInformationsUseCase {

    final LoadCustomerTaskPort loadCustomerTaskPort;

    @Override
    public List<ExportCustomerData> exportCustomerData(LocalDateTime dateTime) {
        List<LoadCustomerTaskPort.LoadCustomerTaskPortModel> customerTaskPortModel = loadCustomerTaskPort.loadCustomerTasksByLastChange(dateTime);
        return customerTaskPortModel.stream().map(this::toMap).collect(Collectors.toList());
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
