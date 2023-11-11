package org.psu.java.example.infrastructure;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.psu.java.example.domain.Ticket;
import org.psu.java.example.utils.NumberUtils;

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TicketImpl implements Ticket {
    @EqualsAndHashCode.Exclude
    int length;
    long number;
}
