/*
 * This file is generated by jOOQ.
 */
package world.good2go.db.jooq.tables.records


import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record2
import org.jooq.Row2
import org.jooq.impl.UpdatableRecordImpl

import world.good2go.db.jooq.tables.Helloworld


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class HelloworldRecord() : UpdatableRecordImpl<HelloworldRecord>(Helloworld.HELLOWORLD), Record2<Int?, String?> {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    public override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    public override fun fieldsRow(): Row2<Int?, String?> = super.fieldsRow() as Row2<Int?, String?>
    public override fun valuesRow(): Row2<Int?, String?> = super.valuesRow() as Row2<Int?, String?>
    public override fun field1(): Field<Int?> = Helloworld.HELLOWORLD.ID
    public override fun field2(): Field<String?> = Helloworld.HELLOWORLD.NAME
    public override fun component1(): Int? = id
    public override fun component2(): String? = name
    public override fun value1(): Int? = id
    public override fun value2(): String? = name

    public override fun value1(value: Int?): HelloworldRecord {
        set(0, value)
        return this
    }

    public override fun value2(value: String?): HelloworldRecord {
        set(1, value)
        return this
    }

    public override fun values(value1: Int?, value2: String?): HelloworldRecord {
        this.value1(value1)
        this.value2(value2)
        return this
    }

    /**
     * Create a detached, initialised HelloworldRecord
     */
    constructor(id: Int? = null, name: String? = null): this() {
        this.id = id
        this.name = name
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised HelloworldRecord
     */
    constructor(value: world.good2go.db.jooq.tables.pojos.Helloworld?): this() {
        if (value != null) {
            this.id = value.id
            this.name = value.name
            resetChangedOnNotNull()
        }
    }
}
