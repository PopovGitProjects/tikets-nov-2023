package org.psu.java.example.infrastructure;

import org.psu.java.example.domain.Ticket;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.IntStream;

class LambdaTicketGenerator implements TicketGenerator {

    @Override
    public Iterator<Ticket> getTickets() {
        return IntStream
                .rangeClosed(0, 1000000)
                .mapToObj(number -> (SixDigitTicket) () -> number)
                .map(Ticket.class::cast)
                .iterator();
    }

    @Override
    public Optional<Ticket> getTicket(int number) {
        if (number < 0 || number >= 1000000) {
            return Optional.empty();
        }
        return Optional.of((SixDigitTicket) () -> number);
    }

    interface SixDigitTicket extends Ticket {
        @Override
        default int getLength() {
            return 6;
        }
    }
}
