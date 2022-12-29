package com.godsonpeya.microblog.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "utilisateur")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    @Column(unique = true)
    var username: String,
    var profession: String,
    var ville: String,
    var pays: String,
    var fullname: String,
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "user")
    var posts: MutableList<Post> = mutableListOf(),
    @CreationTimestamp
    var createdAt: Timestamp? = null,
    @UpdateTimestamp
    var updatedAt: Timestamp? = null,
)