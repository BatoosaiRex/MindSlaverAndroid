package com.example.mindslaver

data class CardItem(
    val id: String,
    val name: String,
    val setName: String,
    val manaCost: String,
    val rarity: String,
    val cardType: String,
    val marketPrice: Double,
    val flavorText: String,
    val imageRes: Int? = null
)

object MockCardRepository {
    val sampleCollection = listOf(
        CardItem(
            id = "1",
            name = "Mindslaver",
            setName = "Mirrodin",
            manaCost = "6",
            rarity = "Mythic Rare",
            cardType = "Legendary Artifact",
            marketPrice = 25.50,
            flavorText = "Target player takes control of another player during that player's next turn."
        ),
        CardItem(
            id = "2",
            name = "Black Lotus",
            setName = "Alpha / Beta",
            manaCost = "0",
            rarity = "Rare",
            cardType = "Artifact",
            marketPrice = 50000.00,
            flavorText = "Add three mana of any single color."
        ),
        CardItem(
            id = "3",
            name = "Force of Will",
            setName = "Alliances",
            manaCost = "3UU",
            rarity = "Uncommon",
            cardType = "Instant",
            marketPrice = 75.00,
            flavorText = "You may pay 1 life and exile a blue card from your hand rather than pay this spell's mana cost."
        ),
        CardItem(
            id = "4",
            name = "Lightning Bolt",
            setName = "Limited Edition Alpha",
            manaCost = "R",
            rarity = "Common",
            cardType = "Instant",
            marketPrice = 2.50,
            flavorText = "Lightning Bolt deals 3 damage to any target."
        ),
        CardItem(
            id = "5",
            name = "Counterspell",
            setName = "Ice Age",
            manaCost = "UU",
            rarity = "Common",
            cardType = "Instant",
            marketPrice = 1.80,
            flavorText = "Counter target spell."
        ),
        CardItem(
            id = "6",
            name = "Jace, the Mind Sculptor",
            setName = "Worldwake",
            manaCost = "2UU",
            rarity = "Mythic Rare",
            cardType = "Legendary Planeswalker - Jace",
            marketPrice = 45.00,
            flavorText = "+2: Look at the top card of target player's library..."
        ),
        CardItem(
            id = "7",
            name = "Snapcaster Mage",
            setName = "Innistrad",
            manaCost = "1U",
            rarity = "Rare",
            cardType = "Creature - Human Wizard",
            marketPrice = 18.00,
            flavorText = "Flash. When Snapcaster Mage enters the battlefield, target instant or sorcery card..."
        ),
        CardItem(
            id = "8",
            name = "Tarmogoyf",
            setName = "Future Sight",
            manaCost = "1G",
            rarity = "Rare",
            cardType = "Creature - Lhurgoyf",
            marketPrice = 12.00,
            flavorText = "Tarmogoyf's power is equal to the number of card types among cards in all graveyards..."
        )
    )
}
