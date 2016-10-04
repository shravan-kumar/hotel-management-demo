package main.groovy.com.pwc.hotelapp

/**
 * Created by shravankumarmadaan on 3/10/2016.
 */
class Restaurant {

    Integer id
    String name
    List<Table> tables = []

    /**
     * This is used to select a particular restaurant from the list of restaurants.
     * @param list of restaurants available.
     */
    private static selectRestaurant(List<Restaurant> restaurantList) {
        Scanner scan = new Scanner(System.in)
        restaurantList.each {
            println("${it.id}: ${it.name}")
        }
        def selectedOption = scan.nextLine()
        def selectedRestaurant = restaurantList.find { Restaurant res -> res.id == selectedOption as Integer }
        return  selectedRestaurant
    }
}
