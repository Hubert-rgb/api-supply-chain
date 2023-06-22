package com.supplyChain.users.supplier;

import com.supplyChain.company.supplierCompany.SupplierCompany;
import com.supplyChain.company.supplierCompany.SupplierCompanyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class SupplierRepositoryTest {
    @Autowired
    private SupplierRepository underTest;
    @Mock
    private SupplierCompanyService supplierCompanyService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void itShouldFindBySupplierCompany_Id() {
        //given
        SupplierCompany supplierCompany = new SupplierCompany();
        supplierCompanyService.saveSupplierCompany(supplierCompany);
        Supplier supplier = new Supplier("name");
        supplier.setSupplierCompany(supplierCompany);
        //when
        System.out.println(supplierCompany.getId());
        List<Supplier> result = underTest.findBySupplierCompany_Id(supplierCompany.getId());

        //then
        assertThat(result).contains(supplier);
    }
}