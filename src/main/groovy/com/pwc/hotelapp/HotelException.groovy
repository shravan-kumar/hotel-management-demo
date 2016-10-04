package main.groovy.com.pwc.hotelapp

/**
 * Created by shravankumarmadaan on 4/10/2016.
 */
class HotelException extends Exception {

    Type type

    HotelException(Type type) {
        super()
        this.type = type
    }

    enum Type {
        MAXIMUM_TABLE_ASSIGNED("You cannot assigned more than four tables to a waiter.")

        String message

        private Type(String message) {
            this.message = message
        }
    }
}
