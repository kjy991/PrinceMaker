package com.makers.princemaker.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class DateTimeUtilsTest : StringSpec({
    "탄생일 출력 검증" {
        val result =
            LocalDateTime.of(2023, 12, 21, 10, 10)
                .toBirthDayString()

        result shouldBe "2023-12-21 탄생"
        result shouldBe "2023-12-21 탄생"

    }
})