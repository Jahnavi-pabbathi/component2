package com.nodemngmt.service

import com.nodemngmt.entity.ComplianceEntity
import com.nodemngmt.repository.ComplianceRepository
import io.micronaut.transaction.annotation.Transactional
import jakarta.inject.Singleton
import kotlin.jvm.optionals.toSet

@Singleton
@Transactional
class ComplianceService (private val complianceRepository: ComplianceRepository){
    fun saveCompliance(complianceEntity: ComplianceEntity):ComplianceEntity{
        System.out.println("compliance "+complianceEntity)
        return complianceRepository.save(complianceEntity)
    }

    fun updateCompliance(complianceEntity: ComplianceEntity):ComplianceEntity{
        var optionalEntity =complianceRepository.findById(complianceEntity.tcin)
        if (optionalEntity.isPresent) {
            val entity = optionalEntity.get()
            entity.isFlammable = complianceEntity.isFlammable
            entity.lithiumClassified = complianceEntity.lithiumClassified
            entity.isHazmatPublishable = complianceEntity.isHazmatPublishable
            return complianceRepository.update(entity)

        }

        return complianceRepository.save(complianceEntity)
    }
}
