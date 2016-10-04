package test.groovy.com.pwc.hotelapp

import main.groovy.com.pwc.hotelapp.Table
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * Created by shravankumarmadaan on 4/10/2016.
 */
class TableTests {

    Table table

    @Before
    void setup() {
        table = new Table()
    }

    @Test
    void shouldInitializeATable() {
        List<Table> tables = Table.intiatesTableList(1)

        assertEquals(1, tables[0].tableNumber)
        assertFalse(tables.isEmpty())
    }

    @Test
    void shouldSearchATable() {
        table.tableNumber = 1
        assertEquals(1, table.tableNumber)
        assertFalse(table == null)
    }
}
