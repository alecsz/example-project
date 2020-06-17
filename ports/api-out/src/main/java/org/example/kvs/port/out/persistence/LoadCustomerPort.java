package org.example.kvs.port.out.persistence;

import lombok.Value;

public interface LoadCustomerPort {

    @Value
    class LoadCustomerPortModel {
        int id;
        String vorname;
        String nachname;
        String email;
        String strasse;
        String strassenzusatz;
        String ort;
        String land;
        String plz;
        String firmenName;
    }

    LoadCustomerPortModel loadCustomerById(int id);


}
