package org.example.kvs.application.export;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.UseCase;
import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class ExportCustomerInformations implements ExportCustomerInformationsUseCase {

    final LoadCustomerTaskPort loadCustomerTaskPort;
    final LoadCustomerPort loadCustomerPort;


    @Override
    public List<ExportCustomerData> exportCustomerData() {
        List<LoadCustomerTaskPort.LoadCustomerTaskPortModel> customerTaskPortModel = loadCustomerTaskPort.loadCustomerTasksByLastChange();
        return null;
    }
}
