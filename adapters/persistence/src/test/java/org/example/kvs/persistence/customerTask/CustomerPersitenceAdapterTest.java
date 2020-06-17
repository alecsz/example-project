package org.example.kvs.persistence.customerTask;

import org.example.kvs.persistence.repositories.CustomerJpaRepository;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({CustomerPersistenceAdapter.class})
class CustomerPersistenceAdapterTest {

    @Autowired
    private CustomerPersistenceAdapter underTest;

    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    @Autowired
    EntityManager em;

    @Test
    @Sql("CustomerPersistenceAdapterTest.sql")
    void readCustomer(){
        LoadCustomerPort.LoadCustomerPortModel loadCustomerPortModel = underTest.loadCustomerById(1);
        assertNotNull(loadCustomerPortModel);
        assertEquals(1, loadCustomerPortModel.getId());
        assertEquals("aut", loadCustomerPortModel.getVorname());

    }


}