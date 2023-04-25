package world.good2go.bishop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BishopApplication

fun main(args: Array<String>) {
    runApplication<BishopApplication>(*args)
}
