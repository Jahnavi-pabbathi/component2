package com.nodemngmt.entity

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import java.time.Instant

@Entity
@Serdeable
@Table(name="compliance_entity")
data class ComplianceEntity(
    @Id
    @Column(name="tcin")
    var tcin: String,
    @Column(name="is_flammable")
    var isFlammable: Boolean,
    @Column(name="is_hazmat_publishable")
    var isHazmatPublishable: Boolean,
    @Column(name="lithium_classified")
    var lithiumClassified: Boolean
){
    constructor() : this("", false, false, false)
}