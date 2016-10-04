package main.groovy.com.pwc.hotelapp

/**
 * Created by shravankumarmadaan on 3/10/2016.
 */
Scanner scan = new Scanner(System.in)
List<Table> tableList1 = Table.intiatesTableList(1)
List<Table> tableList2 = Table.intiatesTableList(21)
List<Restaurant> restaurantList = [new Restaurant(id: 1, name: "restaurant1", tables: tableList1), new Restaurant(id: 2, name: "restaurant2", tables: tableList2)]
List<Waiter> waiterList = Waiter.intiatesWaiterList(8)
String position
Restaurant restaurant
Table selectedTable
Waiter selectedWaiter

println('Welcome to the hotel app. Please enter your name:')

println "\nHello ${scan.nextLine()}, Are you a manager or employee? \tTo exit please press'0'"
position = scan.nextLine().toLowerCase().toString()

while (position != '0') {

    if (position == '0') {
        println "\nGood Bye..."
        System.exit(1)

    } else if (position == 'manager') {
        println "\nPlease select your restaurant:"
        restaurant = Restaurant.selectRestaurant(restaurantList)

        while (!restaurantList.contains(restaurant)) {
            println "\nThat was an invalid restaurant ID, Can you please select again?"
            restaurant = Restaurant.selectRestaurant(restaurantList)
        }

        String action

        println "\nPlease type your action(view or edit):"
        action = scan.nextLine().toLowerCase().toString()

        while (action != 'view' && action != 'edit') {
            println "\nThat was a invalid entry, Do you want to view or edit details?"
            action = scan.nextLine().toLowerCase().toString()
        }

        if (action == 'view') {
            println("\nHere is the list of all the tables for Restaurant: ${restaurant.name}")
            println("Table\tWaiter1\tWaiter2\tWaiter3\tWaiter4")
            restaurant.tables.each { Table table ->
                List<Waiter> waiters = waiterList.findAll { Waiter waiter -> waiter.allTheTables().contains(table) }
                println("${table.tableNumber}\t\t${waiters[0]?.name ?: 'N/A'}\t\t${waiters[1]?.name ?: 'N/A'}\t\t${waiters[2]?.name ?: 'N/A'}\t\t${waiters[3]?.name ?: 'N/A'}")
            }
        } else {
            println "\nPlease select table you want to assign staff"
            selectedTable = Table.selectTable(restaurant.tables)

            while (!restaurant.tables.contains(selectedTable)) {
                println "\nThat was an invalid table ID, Can you please select again?"
                selectedTable = Table.selectTable(restaurant.tables)
            }

            println "\nPlease select waiter you want to assign to table number ${selectedTable.tableNumber}"
            selectedWaiter = Waiter.selectWaiter(waiterList)

            while (!waiterList.contains(selectedWaiter)) {
                println "\nThat was an invalid waiter ID, Can you please select again?"
                selectedWaiter = Waiter.selectWaiter(waiterList)
            }

            try {
                selectedWaiter.addTable(selectedTable)
                println "\nAll done. ${selectedWaiter.name} has been assigned to table ${selectedTable.tableNumber}"
            } catch (HotelException e) {
                println("\nThis transaction cannot be completed. ${e.type.message}")
            }
        }

    } else if (position == 'employee') {
        println "\nPlease select your id from the list"
        selectedWaiter = Waiter.selectWaiter(waiterList)

        while (!waiterList.contains(selectedWaiter)) {
            println "\nThat was an invalid waiter ID, Can you please select again?"
            selectedWaiter = Waiter.selectWaiter(waiterList)
        }

        println "\nHere you go! List of all the tables you have assigned to"
        println("Employee\tTable1\tTable2\tTable3\tTable4")
        println("${selectedWaiter.name}\t\t${selectedWaiter.tables[0]?.tableNumber ?: 'N/A'}\t\t${selectedWaiter.tables[1]?.tableNumber ?: 'N/A'}\t\t${selectedWaiter.tables[2]?.tableNumber ?: 'N/A'}\t\t${selectedWaiter.tables[3]?.tableNumber ?: 'N/A'}")

    } else {
        println("Sorry.. I can't find this position")
    }

    println "\nCan you please enter your position again, Are you a manager or employee? \tTo exit please press'0'"
    position = scan.nextLine().toLowerCase().toString()
}