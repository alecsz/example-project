package org.example.kvs.domain.manage;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class CustomerTask {

    @NotNull
    @Size(max = 255)
    String id;
    @NotNull
    @Size(max = 255)
    String artikelNummer;
    @NotNull
    @Size(max = 255)
    String created;
    @NotNull
    @Size(max = 255)
    String lastChange;
    int customerId;
}
