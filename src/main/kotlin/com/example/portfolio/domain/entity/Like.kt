package com.example.portfolio.domain.entity

import com.bssm.portfolio.domain.entity.Portfolio
import jakarta.persistence.*

@Entity(name = "likes")
class Like(
    portfolio: Portfolio,
    member: Member,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "portfolio_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_LIKE_PORTFOLIO_ID")
    )
    var portfolio: Portfolio = portfolio
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "member_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_LIKE_MEMBER_ID")
    )
    var member: Member = member
        protected set

}
