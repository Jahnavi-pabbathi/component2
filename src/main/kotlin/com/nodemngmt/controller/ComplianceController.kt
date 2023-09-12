package com.nodemngmt.controller

import com.nodemngmt.entity.ComplianceEntity
import com.nodemngmt.service.ComplianceService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Body

@Controller("/component2")
class ComplianceController(private val complianceService:ComplianceService) {
    @Post("/addCompliance")
    fun saveCompliance(complianceEntity: ComplianceEntity):ComplianceEntity{
        System.out.println("compliance "+complianceEntity)
        return complianceService.saveCompliance(complianceEntity)
    }
    @Put("/updateCompliance")
    fun updateCompliance(complianceEntity: ComplianceEntity):ComplianceEntity{
        return complianceService.updateCompliance(complianceEntity)
    }
}