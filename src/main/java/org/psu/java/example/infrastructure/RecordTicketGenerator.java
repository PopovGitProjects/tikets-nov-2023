package org.psu.java.example.infrastructure;

import org.psu.java.example.domain.Ticket;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.IntStream;

class RecordTicketGenerator extends AbstractGenerator {

    @Override
    public Iterator<Ticket> getTickets() {
        return IntStream
                .rangeClosed(0, 1000000)
                .mapToObj(number -> new TicketRecordImpl(6, number))
                .map(Ticket.class::cast)
                .iterator();

    }

    @Override
    public Optional<Ticket> getTicket(int number) {
        if (number < 0 || number >= 1000000) {
            return Optional.empty();
        }
        return Optional.of(new TicketRecordImpl(6, number));
    }
}
