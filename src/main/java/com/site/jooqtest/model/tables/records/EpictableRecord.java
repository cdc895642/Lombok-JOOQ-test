/*
 * This file is generated by jOOQ.
*/
package com.site.jooqtest.model.tables.records;


import com.site.jooqtest.model.tables.Epictable;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class EpictableRecord extends UpdatableRecordImpl<EpictableRecord> implements Record3<Integer, String, Date> {

    private static final long serialVersionUID = -952616881;

    /**
     * Setter for <code>public.epictable.mytable_key</code>.
     */
    public void setMytableKey(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.epictable.mytable_key</code>.
     */
    public Integer getMytableKey() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.epictable.moobars</code>.
     */
    public void setMoobars(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.epictable.moobars</code>.
     */
    public String getMoobars() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.epictable.foobars</code>.
     */
    public void setFoobars(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.epictable.foobars</code>.
     */
    public Date getFoobars() {
        return (Date) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Date> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, Date> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Epictable.EPICTABLE.MYTABLE_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Epictable.EPICTABLE.MOOBARS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Epictable.EPICTABLE.FOOBARS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getMytableKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMoobars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getFoobars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpictableRecord value1(Integer value) {
        setMytableKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpictableRecord value2(String value) {
        setMoobars(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpictableRecord value3(Date value) {
        setFoobars(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpictableRecord values(Integer value1, String value2, Date value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EpictableRecord
     */
    public EpictableRecord() {
        super(Epictable.EPICTABLE);
    }

    /**
     * Create a detached, initialised EpictableRecord
     */
    public EpictableRecord(Integer mytableKey, String moobars, Date foobars) {
        super(Epictable.EPICTABLE);

        set(0, mytableKey);
        set(1, moobars);
        set(2, foobars);
    }
}
