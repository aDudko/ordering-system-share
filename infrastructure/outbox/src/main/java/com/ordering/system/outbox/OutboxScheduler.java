package com.ordering.system.outbox;

public interface OutboxScheduler {

    void processOutboxMessage();

}
