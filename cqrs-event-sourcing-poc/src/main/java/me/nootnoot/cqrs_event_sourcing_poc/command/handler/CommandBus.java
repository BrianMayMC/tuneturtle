package me.nootnoot.cqrs_event_sourcing_poc.command.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandBus {
    private final CommandHandler commandHandler;

    @Autowired
    public CommandBus(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void send(CreateOrderCommand command){
        commandHandler.handle(command);
    }
}
