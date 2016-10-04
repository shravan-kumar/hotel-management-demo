package main.groovy.com.pwc.hotelapp

/**
 * Created by shravankumarmadaan on 3/10/2016.
 */
class Table {

    Integer tableNumber

    public static List<Table> intiatesTableList(int startingNumber) {
        List<Table> tableList = []

        for (int i = startingNumber; i < startingNumber+20; i++) {
            Table table = new Table(tableNumber: i)
            tableList.add(table)
        }

        return tableList
    }

    private static selectTable(List<Table> tableList) {
        Scanner scan = new Scanner(System.in)
        tableList.each {
            println("${it.tableNumber}")
        }
        def selectedOption = scan.nextLine()
        def selectedTable = tableList.find { Table table -> table.tableNumber == selectedOption as Integer }
        return  selectedTable
    }
}
