package com.example.portfolio.domain.entity

import com.example.portfolio.domain.entity.types.RoleType
import jakarta.persistence.*

@Entity(name = "users")
class Member private constructor(
    email: String,
    password: String,
    name: String,
    roleType: RoleType
) : BaseDateTime(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var email: String = email
        protected set

    @Column(nullable = false)
    var password: String = password
        protected set

    @Column(nullable = false)
    var name: String = name
        protected set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var roleType: RoleType = roleType
        protected set

    companion object  {
        fun createAdmin(
            email: String,
            password: String,
            name: String,
        ):Member {
            return Member (
                email= email,
                password= password,
                name= name,
                roleType = RoleType.ADMIN
            )
        }

        fun createUser(
            email: String,
            password: String,
            name: String,
            roleType: RoleType
        ):Member {
            return Member(
                email= email,
                password= password,
                name= name,
                roleType= RoleType.USER
            )
        }
    }
}
