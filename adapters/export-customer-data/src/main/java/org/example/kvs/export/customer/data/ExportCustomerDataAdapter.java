package org.example.kvs.export.customer.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Slf4j
class ExportCustomerDataAdapter {

    final ExportCustomerInformationsUseCase exportCustomerInformationsUseCase;

    @Scheduled(fixedDelay = 10000L, initialDelay = 10L)
    public void startExport(){
        LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00 ,00);
        log.info("start export ...");
        List<ExportCustomerInformationsUseCase.ExportCustomerData> exportCustomerData = exportCustomerInformationsUseCase.exportCustomerData(dateTime);
        exportCustomerData.forEach(c -> log.info("Customer: " + c.toString()));
        log.info("finish export ...");
    }
}
