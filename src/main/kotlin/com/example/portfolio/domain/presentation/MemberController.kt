package com.bssm.portfolio.controller

import com.bssm.portfolio.global.ApiPath
import com.bssm.portfolio.service.MemberService
import com.example.portfolio.domain.presentation.dto.request.MemberDto
import com.example.portfolio.domain.presentation.dto.request.toDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberService,
) {

    @PostMapping(ApiPath.MEMBER_V1)
    fun createMember(@RequestBody requestDto: MemberDto): Long {
        return memberService.create(requestDto.toDto())
    }
}
