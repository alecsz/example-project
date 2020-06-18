package org.example.kvs.domain.manage;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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
    LocalDateTime created;
    @NotNull
    LocalDateTime lastChange;
    int customerId;
}
