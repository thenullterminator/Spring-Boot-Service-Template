package world.good2go.bishop

import org.jooq.DSLContext
import org.jooq.impl.DSL.asterisk
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import world.good2go.db.jooq.tables.references.HELLOWORLD

@RestController
@RequestMapping("api/")
class HelloWorldController(
    private val dslContext: DSLContext,
) {

    @GetMapping("/hello")
    fun helloWorld(): String {
        dslContext.insertInto(HELLOWORLD).set(
            HELLOWORLD.NAME,
            "version 1",
        ).execute()

        dslContext.select(asterisk()).from(HELLOWORLD).fetch()

        return "Hello World. New Beginnings."
    }
}
