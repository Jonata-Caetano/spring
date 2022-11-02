package com.bmarques.springarchunitmvcexample

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

class ArchUnitAnnotationCheckTest {

    private var importedClasses: JavaClasses? = null

    @BeforeEach
    fun setup() {
        importedClasses = ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.bmarques.springarchunitmvcexample")
    }

    @Test
    fun `Field injection not should be use with Autowired annotation`() =
        ArchRuleDefinition.noFields()
                .should().beAnnotatedWith(Autowired::class.java)
                .check(importedClasses)

    @Test
    fun `Repository classes should have spring repository annotation`() =
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..repository..")
                .should().beAnnotatedWith(Repository::class.java)
                .check(importedClasses)

    @Test
    fun `Service classes should have spring service annotation`() =
        ArchRuleDefinition.classes()
                .that().resideInAPackage("..service..")
                .should().beAnnotatedWith(Service::class.java)
                .check(importedClasses)
}