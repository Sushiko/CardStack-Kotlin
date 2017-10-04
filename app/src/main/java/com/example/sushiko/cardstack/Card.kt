package com.example.sushiko.cardstack

/**
 * Created by Sushiko on 10/2/17.
 */

class Card {
    var number: Int = 0
    var suit: Suits? = null

    constructor() {
        this.number = 0
        this.suit = null
    }

    constructor(number: Int, mySuit: Suits) {
        this.number = number
        this.suit = mySuit
    }
}
