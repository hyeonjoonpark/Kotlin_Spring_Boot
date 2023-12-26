package com.bssm.portfolio.domain.entity

import com.example.portfolio.domain.entity.BaseDateTime
import com.example.portfolio.domain.entity.Contributor
import com.example.portfolio.domain.entity.Member
import com.example.portfolio.domain.entity.types.PublicType
import com.example.portfolio.domain.entity.types.ThemeType
import jakarta.persistence.*

@Entity
class Portfolio(
    title: String,
    theme: ThemeType,
    public: PublicType,
    description: String,
    webUrl: String,
    gitUrl: String,
    member: Member,
    videoFile: AttachFile,
    thumbnailFile: AttachFile,
) : BaseDateTime() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var theme: ThemeType = theme
        protected set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var protectType: PublicType = public
        protected set

    @Column(columnDefinition = "TEXT")
    var description: String = description
        protected set

    @Column(columnDefinition = "TEXT")
    var webUrl: String = webUrl
        protected set

    @Column(columnDefinition = "TEXT")
    var gitUrl: String = gitUrl
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "video_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_VIDEO_FILE_ID")
    )
    var videoFile: AttachFile = videoFile
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "thumbnail_file_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_THUMBNAIL_FILE_ID")
    )
    var thumbnailFile: AttachFile = thumbnailFile
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "member_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_PORTFOLIO_MEMBER_ID")
    )
    var member: Member = member
        protected set

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true)
    var comments: List<Comment> = mutableListOf()
        protected set

    @OneToMany(mappedBy = "portfolio", cascade = [CascadeType.ALL], orphanRemoval = true)
    var contributors: List<Contributor> = mutableListOf()
        protected set
}
