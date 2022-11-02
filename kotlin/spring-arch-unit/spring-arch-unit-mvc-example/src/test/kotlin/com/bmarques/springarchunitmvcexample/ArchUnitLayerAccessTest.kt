package com.bmarques.springarchunitmvcexample

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArchUnitLayerAccessTest {

    private var importedClasses: JavaClasses? = null

    @BeforeEach
    fun setup() {
        importedClasses = ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.bmarques.springarchunitmvcexample")
    }

    @Test
    fun `Layered architecture should be respected`() {
        Architectures.layeredArchitecture()
                .consideringAllDependencies()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repository..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                .check(importedClasses)
    }

    @Test
    fun `Services should only be accessed by controllers`() {
        val myRule: ArchRule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..service..")
                .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..")
        myRule.check(importedClasses)
    }

    @Test
    fun `Repository should only be accessed by services`() {
        val myRule: ArchRule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..repository..")
                .should().onlyBeAccessed().byAnyPackage("..service..")
        myRule.check(importedClasses)
    }


    @Test
    fun `Customer should only be accessed by invoice`() {
        val importedClasses = ClassFileImporter().importPackages("com.bmarques.springarchunitmvcexample.domain")
        val myRule: ArchRule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..customer..")
                .should().dependOnClassesThat().resideInAPackage("..invoice..")
        myRule.check(importedClasses)
    }
}