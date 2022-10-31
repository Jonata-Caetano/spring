package com.bmarques.springarchunitmvcexample;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchUnitPackageCheckTest {

    @Test
    public void invoiceClassesOnlyShouldResideInInvoicePackage() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.bmarques.springarchunitmvcexample.domain");

        ArchRule myRule = classes().that().haveSimpleNameStartingWith("Invoice")
                .should().resideInAPackage("com.bmarques.springarchunitmvcexample.domain.invoice");

        myRule.check(importedClasses);
    }


    @Test
    public void invoiceClassesOnlyShouldResideInInvoicePackageUsingPrefixInvoice() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.bmarques.springarchunitmvcexample.domain");

        ArchRule myRule = classes().that().haveSimpleNameContaining("Invoice")
                .should().resideInAPackage("com.bmarques.springarchunitmvcexample.domain.invoice");

        myRule.check(importedClasses);
    }
}
