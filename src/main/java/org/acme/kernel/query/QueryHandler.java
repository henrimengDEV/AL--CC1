package org.acme.kernel.query;

/**
 * @param <Q> query
 * @param <R> resolve
 */
public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
