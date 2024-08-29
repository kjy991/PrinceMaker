package com.makers.princemaker.service

import com.makers.princemaker.code.PrinceMakerErrorCode
import com.makers.princemaker.controller.CreatePrince
import com.makers.princemaker.entity.dummyPrince
import com.makers.princemaker.exception.PrinceMakerException
import com.makers.princemaker.repository.PrinceRepository
import com.makers.princemaker.repository.WoundedPrinceRepository
import com.makers.princemaker.type.PrinceLevel.*
import com.makers.princemaker.type.SkillType.*
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class PrinceMakerServiceKotest : BehaviorSpec({
    val princeRepository: PrinceRepository = mockk()
    val woundedPrinceRepository: WoundedPrinceRepository = mockk()
    val princeMakerService = PrinceMakerService(princeRepository, woundedPrinceRepository)

    Given("프린스 생성 요청이 올 때") {

        val request = CreatePrince.Request(
            MIDDLE_PRINCE,
            INTELLECTUAL,
            7,
            "princeId",
            "name",
            28
        )
        val juniorPrince =
            dummyPrince(princeLevel = MIDDLE_PRINCE, skillType = INTELLECTUAL, experienceYears = 7)



        every { princeRepository.save(any()) } returns juniorPrince

        When("princeId가 중복되지 않고 정상 요청이 오면") {
            every {
                (princeRepository.findByPrinceId(any()))
            } returns null

            val result =
                dummyPrince(princeLevel = MIDDLE_PRINCE, skillType = INTELLECTUAL, experienceYears = 7)
            Then("정상 응답") {
                assertSoftly(result) {
                    princeLevel shouldBe MIDDLE_PRINCE
                    skillType shouldBe INTELLECTUAL
                    experienceYears shouldBe 7
                }
            }
        }

        When("princeId가 중복되고 정상 요청이 오면") {
            every {
                (princeRepository.findByPrinceId(any()))
            } returns juniorPrince

            val ex = shouldThrow<PrinceMakerException> {
                princeMakerService.createPrince(request)
            }
            Then("중복 오류 응답") {
                ex.princeMakerErrorCode shouldBe PrinceMakerErrorCode.DUPLICATED_PRINCE_ID
            }
        }

    }
})
