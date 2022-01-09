package org.acme.kernel.query;

import org.acme.kernel.query.Query;

public interface QueryBus {

    <Q extends Query, R> R send(Q query);
}
