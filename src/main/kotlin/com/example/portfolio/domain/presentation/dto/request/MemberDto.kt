package com.example.portfolio.domain.presentation.dto.request

import com.bssm.portfolio.service.dto.CreateMemberDto

data class MemberDto(
    val email: String,
    val password: String,
    val name: String,
)

fun MemberDto.toDto(): CreateMemberDto {
    return CreateMemberDto(
        email = email,
        password = password,
        name = name
    )
}
