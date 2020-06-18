package org.example.kvs.port.out.persistence;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface LoadCustomerTaskPort {

    @Value
    class LoadCustomerTaskPortModel {
        String id;
        String artikelNummer;
        LocalDateTime created;
        LocalDateTime lastChange;
        LoadCustomerPort.LoadCustomerPortModel customer;
    }

    List<LoadCustomerTaskPortModel> loadCustomerTasksByLastChange(LocalDateTime dateTime);

    LoadCustomerTaskPortModel loadCustomerTaskById(int id);
}
