package org.example.kvs.export.customer.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kvs.port.in.export.ExportCustomerInformationsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
@Slf4j
class ExportCustomerDataAdapter {

    final ExportCustomerInformationsUseCase exportCustomerInformationsUseCase;

    @Scheduled(fixedDelay = 10000L, initialDelay = 10L)
    public void startExport(){
        LocalDateTime dateTime = LocalDateTime.of(2019, 01, 01, 00 ,00);
        log.info("start export ..." );
        log.info("last export date was: " + dateTime.toString());
        List<ExportCustomerInformationsUseCase.ExportCustomerData> exportCustomerData = exportCustomerInformationsUseCase.exportCustomerData(dateTime);
        exportCustomerData.forEach(c -> log.info("Customer: " + c.toString()));
        assert exportCustomerData.size() > 0;
        writeCSVFile(exportCustomerData.get(0).getLand() + LocalDateTime.now() + ".csv", exportCustomerData);
        log.info("finish export ...");
    }

    static void writeCSVFile(String csvFileName, List<ExportCustomerInformationsUseCase.ExportCustomerData> data) {
        ICsvBeanWriter beanWriter = null;
        CellProcessor[] processors = new CellProcessor[] {
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
        };

        try {
            beanWriter = new CsvBeanWriter(new FileWriter(csvFileName),
                    CsvPreference.STANDARD_PREFERENCE);
            String[] header = {"Firma", "Strasse", "Strassenzusatz", "Ort", "Land", "PLZ", "Vorname", "Nachname", "KundenID"};
            beanWriter.writeHeader(header);

            for (ExportCustomerInformationsUseCase.ExportCustomerData customerData : data) {
                beanWriter.write(customerData, header, processors);
            }

        } catch (IOException ex) {
            System.err.println("Error writing the CSV file: " + ex);
        } finally {
            if (beanWriter != null) {
                try {
                    beanWriter.close();
                } catch (IOException ex) {
                    System.err.println("Error closing the writer: " + ex);
                }
            }
        }
    }
}
