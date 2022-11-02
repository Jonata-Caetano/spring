package com.bmarques.springarchunitmvcexample

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.junit.jupiter.api.Test

class ArchUnitPackageCheckTest {

    @Test
    fun `Invoice classes only should reside in invoice package`() {
        val importedClasses = ClassFileImporter().importPackages("com.bmarques.springarchunitmvcexample.domain")
        val myRule: ArchRule = ArchRuleDefinition.classes().that().haveSimpleNameStartingWith("Invoice")
                .should().resideInAPackage("com.bmarques.springarchunitmvcexample.domain.invoice")
        myRule.check(importedClasses)
    }


    @Test
    fun `Invoice classes only should reside in invoice package using prefix invoice`() {
        val importedClasses = ClassFileImporter().importPackages("com.bmarques.springarchunitmvcexample.domain")
        val myRule: ArchRule = ArchRuleDefinition.classes().that().haveSimpleNameContaining("Invoice")
                .should().resideInAPackage("com.bmarques.springarchunitmvcexample.domain.invoice")
        myRule.check(importedClasses)
    }
}