package org.example.kvs.port.out.persistence;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public interface LoadCustomerTaskPort {

    @Value
    class LoadCustomerTaskPortModel {
        String id;
        String artikelNummer;
        String created;
        String lastChange;
        LoadCustomerPort.LoadCustomerPortModel customer;
    }

    List<LoadCustomerTaskPortModel> loadCustomerTasksByLastChange();
}
