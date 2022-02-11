package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.roundToInt

class DifferentCommissionKtTest {
    
    @Test
    fun formatResult() {
        val amount = 70000.00000
        val actualAmountChargedVisaStandardCommission = "Текущий перевод с учетом комиссии составит: 70000,00 руб."
        assertEquals(
            formatResult(amount),
            actualAmountChargedVisaStandardCommission
        )
    }

    @Test
    fun getAmountChargedVkPay() {
        val typeCard = "Vk Pay"
        val amount = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70000.00

        val amountChargedVisaStandardCommission = getAmountCharged(
            typeCard,
            amount,
            minCommission,
            standardCommission,
            minCommission2,
            standardCommission2,
            limit1,
            previousMonthAmount
        )

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }


    @Test
    fun getAmountChargedVisaWithStandardCommission() {
        val typeCard = "Visa"
        val amount = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70525.00

        val amountChargedVisaStandardCommission = getAmountCharged(
            typeCard,
            amount,
            minCommission,
            standardCommission,
            minCommission2,
            standardCommission2,
            limit1,
            previousMonthAmount
        )

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )

    }


    @Test
    fun getAmountChargedMirWithStandardCommission() {
        val typeCard = "Мир"
        val amount = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70525.00

        val amountChargedVisaStandardCommission = getAmountCharged(
            typeCard,
            amount,
            minCommission,
            standardCommission,
            minCommission2,
            standardCommission2,
            limit1,
            previousMonthAmount
        )

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }


    @Test
    fun getAmountChargedMasterCardIfAmountIsLessTheLimit() {
        val typeCard = "MasterCard"
        val amount = 70000.00 // текущий перевод
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075

        val amountChargedVisaStandardCommission = getAmountCharged(
            typeCard,
            amount,
            minCommission,
            standardCommission,
            minCommission2,
            standardCommission2,
            limit1,
            previousMonthAmount
        )

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }

    @Test
    fun getAmountChargedMaestroIfAmountIsLessTheLimit() {
        val typeCard = "Maestro"
        val amount = 70000.00
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075

        val amountChargedVisaStandardCommission = getAmountCharged(
            typeCard,
            amount,
            minCommission,
            standardCommission,
            minCommission2,
            standardCommission2,
            limit1,
            previousMonthAmount
        )

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }

    @Test
    fun getAmountChargedVisaAndMirStandardCommission() {
        val amount = 70000.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075
        val actualAmountChargedVisaStandardCommission = 70525.00

        val amountChargedVisaStandardCommission = getAmountCharged1(amount, minCommission, standardCommission)

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }

    @Test
    fun getAmountChargedVisaAndMirWithMinCommission() {
        val amount = 100.00
        val minCommission = 35.00
        val standardCommission = amount * 0.0075
        val actualAmountChargedVisaStandardCommission = 135.00

        val amountChargedVisaStandardCommission = getAmountCharged1(amount, minCommission, standardCommission)

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }

    @Test
    fun getAmountChargedMasterCardAndMaestroWithMinCommission() {
        val amount = 70000.00
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 70000.00

        val amountChargedVisaStandardCommission =
            getAmountCharged2(amount, minCommission2, standardCommission2, limit1, previousMonthAmount)

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }

    @Test
    fun getAmountChargedMasterCardAndMaestroWithStandardCommission() {
        val amount = 76000.00
        val minCommission2 = 20.00
        val standardCommission2 = amount * 0.006
        val limit1 = 75000.00
        val previousMonthAmount = 0.00
        val actualAmountChargedVisaStandardCommission = 76476.00

        val amountChargedVisaStandardCommission =
            getAmountCharged2(amount, minCommission2, standardCommission2, limit1, previousMonthAmount)

        assertEquals(
            actualAmountChargedVisaStandardCommission.roundToInt(),
            amountChargedVisaStandardCommission.roundToInt()
        )
    }
}