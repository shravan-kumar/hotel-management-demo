package test.groovy.com.pwc.hotelapp

import main.groovy.com.pwc.hotelapp.Restaurant
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse

/**
 * Created by shravankumarmadaan on 4/10/2016.
 */
class RestaurantTests {

    Restaurant restaurant

    @Before
    void setup() {
        restaurant = new Restaurant()
    }

    @Test
    void shouldBeAbleToSelectRestaurant() {
        restaurant.id = 1
        restaurant.name = 'restaurant1'
        assertEquals(1, restaurant.id)
        assertEquals('restaurant1', restaurant.name)
        assertFalse(restaurant == null)
    }
}
