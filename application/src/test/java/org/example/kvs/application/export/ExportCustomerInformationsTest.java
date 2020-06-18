package org.example.kvs.application.export;

import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExportCustomerInformationsTest {

    @Autowired
    private ExportCustomerInformations underTest;


    @Test
    void exportData(){
        LocalDateTime date = LocalDateTime.of(2000, 01, 01, 00, 00);
        List<ExportCustomerInformationsUseCase.ExportCustomerData> exportCustomerData = underTest.exportCustomerData(date);

        assertNotNull(exportCustomerData);
        assertFalse(exportCustomerData.isEmpty());
    }
}