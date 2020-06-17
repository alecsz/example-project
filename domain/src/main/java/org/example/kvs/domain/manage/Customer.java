package org.example.kvs.domain.manage;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Customer {

    int id;
    @NotNull
    @Size(max = 100)
    String vorname;
    @NotNull
    @Size(max = 100)
    String nachname;
    @NotNull
    @Size(max = 100)
    String email;
    @NotNull
    @Size(max = 255)
    String strasse;
    @NotNull
    @Size(max = 255)
    String strassenzusatz;
    @NotNull
    @Size(max = 255)
    String ort;
    @NotNull
    @Size(max = 255)
    String land;
    @NotNull
    @Size(max = 255)
    String plz;
    @NotNull
    @Size(max = 100)
    String firmenName;


}
