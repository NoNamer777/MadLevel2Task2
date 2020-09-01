package com.nonamer777.madlevel2task2.model

class Statement(val statement: String, val isTruth: Boolean) {

    companion object {
        val STATEMENTS = arrayOf(
            "A 'val' and 'var' are the same",
            "Mobile Application Development grants 12 ECTS",
            "A Unit in Kotlin corresponds to a void in Java",
            "In Kotlin 'when' replaces the 'switch' operator in Java",
            "In the Player's Handbook for D&D 5e are 9 Races for character creation",
            "You need to make 2 death saving throws in D&D 5e when your character dies",
            "A round in D&D 5e has a duration of roughly 6 seconds",
            "In D&D 5e you can cast any spell as a bonus action",
            "A character needs 300 xp to reach level 2 in D&D 5e",
            "As a Fighter you can't cast spells in D&D 5e",
            "Attacking an unconscious character does nothing special in D&D 5e",
            "Healing potions in D&D 5e can not be created by characters",
            "Characters in D&D 5e don't need food or water"
        )

        val STATEMENT_CONDITION = arrayOf(
            false,
            true,
            true,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            false,
            false,
            false
        )
    }
}
