package test.groovy.com.pwc.hotelapp

import main.groovy.com.pwc.hotelapp.HotelException
import main.groovy.com.pwc.hotelapp.Table
import main.groovy.com.pwc.hotelapp.Waiter
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse

/**
 * Created by shravankumarmadaan on 4/10/2016.
 */
class WaiterTests {

    Waiter waiter

    @Before
    void setup() {
        waiter = new Waiter()
    }

    @Test
    void shouldInitializeATable() {
        List<Waiter> waiters = Waiter.intiatesWaiterList(1)

        assertEquals(1, waiters[0].id)
        assertFalse(waiters.isEmpty())
    }

    @Test
    void shouldSearchAWaiter() {
        waiter.id = 1
        waiter.name = 'Waiter1'
        assertEquals(1, waiter.id)
        assertEquals('Waiter1', waiter.name)
        assertFalse(waiter == null)
    }

    @Test
    void shouldThrowAnException() {
        waiter.addTable(new Table(tableNumber: 1))
        def maximumTables = 0
        try {
            if (maximumTables < waiter.tablesAssigned()) {
                throw new HotelException(HotelException.Type.MAXIMUM_TABLE_ASSIGNED)
            } else {
                waiter.addTable(new Table(tableNumber: 2))
            }
        } catch (HotelException e) {
            assertEquals('You cannot assigned more than four tables to a waiter.', e.type.message)
            assertEquals(1, waiter.tablesAssigned())
            Table table2 = new Table(tableNumber: 2)
            assertFalse(waiter.tables.contains(table2))
        }
    }
}
