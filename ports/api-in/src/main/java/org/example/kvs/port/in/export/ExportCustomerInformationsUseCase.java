package org.example.kvs.port.in.export;

import lombok.Value;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public interface ExportCustomerInformationsUseCase {

    @Value
    class ExportCustomerData {
        String firma;
        String strasse;
        String strassenZusatz;
        String ort;
        String land;
        String plz;
        String vorname;
        String nachname;
        int kundenID;
    }

    List<ExportCustomerData> exportCustomerData(LocalDateTime dateTime);
}
