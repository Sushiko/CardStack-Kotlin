package com.example.sushiko.cardstack

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {

    // Private declartions
    private var topNum: TextView? = null
    private var botNum: TextView? = null
    private var topIcon: ImageView? = null
    private var botIcon: ImageView? = null
    private var mainIcon: ImageView? = null
    private var card: Card? = null
    private val cardStack = Stack<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declarations
        this.topNum = findViewById(R.id.tv_topNum) as TextView
        this.botNum = findViewById(R.id.tv_botNum) as TextView
        this.topIcon = findViewById(R.id.iv_topIcon) as ImageView
        this.botIcon = findViewById(R.id.iv_botIcon) as ImageView
        this.mainIcon = findViewById(R.id.iv_mainIcon) as ImageView

        // Build deck
        for (i in 2..14) {

            card = Card(i, Suits.DIAMONDS)
            cardStack.push(card)
            card = Card(i, Suits.CLOVERS)
            cardStack.push(card)
            card = Card(i, Suits.HEARTS)
            cardStack.push(card)
            card = Card(i, Suits.SPADES)
            cardStack.push(card)
        }

        // Shuffle Deck
        Collections.shuffle(cardStack)
    }

    // Generates card with a Card object
    private fun genCard(card: Card?) {

        // gets enum Suits from card object
        when (card!!.suit) {

            Suits.HEARTS -> {
                mainIcon!!.setImageResource(R.drawable.hearts)
                topIcon!!.setImageResource(R.drawable.hearts)
                botIcon!!.setImageResource(R.drawable.hearts)
                topNum!!.setTextColor(Color.RED)
                botNum!!.setTextColor(Color.RED)
            }

            Suits.CLOVERS -> {
                mainIcon!!.setImageResource(R.drawable.clubs)
                topIcon!!.setImageResource(R.drawable.clubs)
                botIcon!!.setImageResource(R.drawable.clubs)
                topNum!!.setTextColor(Color.BLACK)
                botNum!!.setTextColor(Color.BLACK)
            }

            Suits.DIAMONDS -> {
                mainIcon!!.setImageResource(R.drawable.diamonds)
                topIcon!!.setImageResource(R.drawable.diamonds)
                botIcon!!.setImageResource(R.drawable.diamonds)
                topNum!!.setTextColor(Color.RED)
                botNum!!.setTextColor(Color.RED)
            }

            Suits.SPADES -> {
                mainIcon!!.setImageResource(R.drawable.spades)
                topIcon!!.setImageResource(R.drawable.spades)
                botIcon!!.setImageResource(R.drawable.spades)
                topNum!!.setTextColor(Color.BLACK)
                botNum!!.setTextColor(Color.BLACK)
            }
        }

        // Gets the number 2-14; 11,12,13,14 are translated to J,Q,K,A
        when (card.number) {
            2 -> {
                topNum!!.setText(R.string.two)
                botNum!!.setText(R.string.two)
            }
            3 -> {
                topNum!!.setText(R.string.three)
                botNum!!.setText(R.string.three)
            }
            4 -> {
                topNum!!.setText(R.string.four)
                botNum!!.setText(R.string.four)
            }
            5 -> {
                topNum!!.setText(R.string.five)
                botNum!!.setText(R.string.five)
            }
            6 -> {
                topNum!!.setText(R.string.six)
                botNum!!.setText(R.string.six)
            }
            7 -> {
                topNum!!.setText(R.string.seven)
                botNum!!.setText(R.string.seven)
            }
            8 -> {
                topNum!!.setText(R.string.eight)
                botNum!!.setText(R.string.eight)
            }
            9 -> {
                topNum!!.setText(R.string.nine)
                botNum!!.setText(R.string.nine)
            }
            10 -> {
                topNum!!.setText(R.string.ten)
                botNum!!.setText(R.string.ten)
            }
            11 -> {
                topNum!!.setText(R.string.j)
                botNum!!.setText(R.string.j)
            }
            12 -> {
                topNum!!.setText(R.string.q)
                botNum!!.setText(R.string.q)
            }
            13 -> {
                topNum!!.setText(R.string.k)
                botNum!!.setText(R.string.k)
            }
            14 -> {
                topNum!!.setText(R.string.a)
                botNum!!.setText(R.string.a)
            }
        }
    }

    // Clicking on the screen generates a new card, unless there are no more cards
    fun onClickScreen(view: View) {
        if (!cardStack.empty()) {
            card = cardStack.pop()
            genCard(card)
        } else
            finish()
    }

}
