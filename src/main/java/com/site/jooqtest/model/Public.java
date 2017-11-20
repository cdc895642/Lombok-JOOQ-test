/*
 * This file is generated by jOOQ.
*/
package com.site.jooqtest.model;


import com.site.jooqtest.model.tables.Epictable;
import com.site.jooqtest.model.tables.Producers;
import com.site.jooqtest.model.tables.Products;
import com.site.jooqtest.model.tables.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1078320893;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.epictable</code>.
     */
    public final Epictable EPICTABLE = com.site.jooqtest.model.tables.Epictable.EPICTABLE;

    /**
     * The table <code>public.producers</code>.
     */
    public final Producers PRODUCERS = com.site.jooqtest.model.tables.Producers.PRODUCERS;

    /**
     * The table <code>public.products</code>.
     */
    public final Products PRODUCTS = com.site.jooqtest.model.tables.Products.PRODUCTS;

    /**
     * The table <code>public.users</code>.
     */
    public final Users USERS = com.site.jooqtest.model.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.EPICTABLE_MYTABLE_KEY_SEQ,
            Sequences.PRODUCERS_ID_SEQ,
            Sequences.PRODUCTS_PRODUCTS_ID_SEQ,
            Sequences.USER_IDS);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Epictable.EPICTABLE,
            Producers.PRODUCERS,
            Products.PRODUCTS,
            Users.USERS);
    }
}
