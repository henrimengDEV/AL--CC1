package org.acme.kernel.command;

/**
 * @param <C> command
 * @param <R> resolve
 */
public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
