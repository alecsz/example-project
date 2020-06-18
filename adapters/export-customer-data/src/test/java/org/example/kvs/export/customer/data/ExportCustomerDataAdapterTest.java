package org.example.kvs.export.customer.data;

import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Import(ExportCustomerDataAdapter.class)
@RunWith(SpringRunner.class)
class ExportCustomerDataAdapterTest {

    @Autowired
    ExportCustomerDataAdapter underTest;

    @MockBean
    ExportCustomerInformationsUseCase exportCustomerInformationsUseCase;

    //TODO Fix Tests
    @Test
    void startExport(){
        LocalDateTime dateTime = LocalDateTime.of(2000,01, 01, 00, 00);

        List<ExportCustomerInformationsUseCase.ExportCustomerData> customerData = new ArrayList<>();
        customerData.add(new ExportCustomerInformationsUseCase.ExportCustomerData("a", "b", "c", "d", "e", "f", "g", "h", 1));
        when(exportCustomerInformationsUseCase.exportCustomerData(dateTime)).thenReturn(customerData);
        underTest.startExport();
        verify(exportCustomerInformationsUseCase).exportCustomerData(dateTime);
    }

}