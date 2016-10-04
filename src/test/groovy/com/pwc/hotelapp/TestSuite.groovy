package test.groovy.com.pwc.hotelapp

import main.groovy.com.pwc.hotelapp.Table
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Created by shravankumarmadaan on 4/10/2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses([
        RestaurantTests.class,
        TableTests.class,
        WaiterTests.class
])
public class TestSuite {
    // JUnit Test Suite for Frame and Match Tests
}
