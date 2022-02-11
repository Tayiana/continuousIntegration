package ru.netology

/**Задача про комиссию*/

fun main() {
    val typeCard= "Visa"
    val amount = 70000.00 // текущий перевод
    val minCommission = 35.00
    val minCommission2 = 20.00
    val standardCommission = amount * 0.0075
    val standardCommission2 = amount * 0.006
    val limit1 = 75000.00
    val previousMonthAmount= 0.00

    val amountCharged = getAmountCharged(typeCard,amount, minCommission, standardCommission,  minCommission2, standardCommission2, limit1, previousMonthAmount)
    val formatAmountCharged = formatResult(amountCharged)
    println(formatAmountCharged)
}

fun getAmountCharged(typeCard: String = "Vk Pay", amount: Double, minCommission: Double, standardCommission: Double, minCommission2: Double, standardCommission2: Double, limit1: Double, previousMonthAmount: Double = 0.00
): Double {
    return when (typeCard) {
        "Visa", "Мир" -> getAmountCharged1(amount, minCommission, standardCommission)
        "MasterCard", "Maestro" -> getAmountCharged2(amount, minCommission2, standardCommission2, limit1, previousMonthAmount)
        else -> { amount }
    }

}

fun formatResult(amountCharged: Double): String {
    return "Текущий перевод с учетом комиссии составит: " + String.format("%.2f", amountCharged )+ " руб."

}

// для типов карт "Visa", "Мир"
fun getAmountCharged1(amount: Double, minCommission: Double, standardCommission: Double): Double {
    return if (standardCommission < minCommission)
        amount + minCommission
    else
        amount + standardCommission
}

//для типов карт "MasterCard", "Maestro"
fun getAmountCharged2(amount: Double, minCommission2: Double, standardCommission2: Double, limit1: Double, previousMonthAmount: Double): Double {
    return if (amount + previousMonthAmount >= limit1)
        amount + standardCommission2 + minCommission2
    else
        amount
}