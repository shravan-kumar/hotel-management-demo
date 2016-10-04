package main.groovy.com.pwc.hotelapp

/**
 * Created by shravankumarmadaan on 3/10/2016.
 */
class Waiter {

    private final static Integer TABLES = 4

    Integer id
    String name

    List<Table> tables = []

    /**
     * Total tables assigned to a waiter
     * @return Tables assigned
     */
    Integer tablesAssigned() {
        return this.tables.size()
    }

    /**
     * List of tables assigned to a waiter
     * @return Tables list
     */
    List<Table> allTheTables() {
        return this.tables
    }

    /**
     * This add a table to waiter and also checks if there are already four tables assigned or not
     * @param table object needs to be assigned
     * @throws HotelException When a manager tries to assign the fifth table to a waiter
     */
    List<Table> addTable(Table table) throws HotelException {
        if (this.tablesAssigned() >= Waiter.TABLES) {
            throw new HotelException(HotelException.Type.MAXIMUM_TABLE_ASSIGNED)
        } else {
            this.tables.add(table)
        }
        return this.tables
    }

    /**
     * This is used to creates waiters.
     * @param number of waiters needs to be created.
     */
    public static List<Waiter> intiatesWaiterList(int totalWaiters) {
        List<Waiter> waiters = []

        for (int i = 1; i <= totalWaiters; i++) {
            Waiter waiter = new Waiter(id: i, name: "Waiter${i}")
            waiters.add(waiter)
        }

        return waiters
    }

    /**
     * This is used to select a particular waiter to be assigned for a table.
     * @param list of waiters.
     */
    private static selectWaiter(List<Waiter> waiterList) {
        Scanner scan = new Scanner(System.in)
        waiterList.each {
            println("${it.id}: ${it.name}")
        }
        def selectedOption = scan.nextLine()
        def selectedWaiter = waiterList.find { Waiter waiter -> waiter.id == selectedOption as Integer }
        return  selectedWaiter
    }
}
