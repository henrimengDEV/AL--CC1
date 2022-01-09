package org.acme.kernel.command;

import org.acme.kernel.command.Command;

public interface CommandBus {

    <C extends Command, R> R send(C command);
}
