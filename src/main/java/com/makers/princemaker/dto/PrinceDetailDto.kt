package com.makers.princemaker.dto

import com.makers.princemaker.code.StatusCode
import com.makers.princemaker.entity.Prince
import com.makers.princemaker.type.PrinceLevel
import com.makers.princemaker.type.SkillType
import com.makers.princemaker.util.toBirthDayString
import lombok.*

data class PrinceDetailDto(
    val princeLevel: PrinceLevel?,
    val skillType: SkillType?,
    val experienceYears: Int?,
    val princeId: String?,
    val name: String?,
    val age: Int?,
    val status: StatusCode?,
    val birthDate: String?,
) {
}

fun Prince.toPrinceDetailDto() = PrinceDetailDto(
    princeLevel = princeLevel,
    skillType = skillType,
    experienceYears = experienceYears,
    princeId = princeId,
    name = name,
    age = age,
    status = status,
    birthDate = createdAt!!.toBirthDayString(),
)