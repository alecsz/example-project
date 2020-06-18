package org.example.kvs.persistence.customerTask;

import org.example.kvs.persistence.repositories.CustomerJpaRepository;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;
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
    void readCustomer_OK(){
        LoadCustomerPort.LoadCustomerPortModel loadCustomerPortModel = underTest.loadCustomerById(101);
        assertNotNull(loadCustomerPortModel);
        assertEquals(101, loadCustomerPortModel.getId());
        assertEquals("vorname", loadCustomerPortModel.getVorname());
    }

    @Test
    @Sql("CustomerPersistenceAdapterTest.sql")
    void readCustomerTaskWithCustomerObj_OK(){
        LoadCustomerTaskPort.LoadCustomerTaskPortModel loadCustomerTaskPortModel = underTest.loadCustomerTaskById(99999);
        assertNotNull(loadCustomerTaskPortModel);
        assertEquals("99999", loadCustomerTaskPortModel.getId());
        assertEquals(101, loadCustomerTaskPortModel.getCustomer().getId());
        assertEquals("vorname", loadCustomerTaskPortModel.getCustomer().getVorname());
        assertEquals("nachname", loadCustomerTaskPortModel.getCustomer().getNachname());
        assertEquals("email@examplee.org", loadCustomerTaskPortModel.getCustomer().getEmail());
        assertEquals("strasse", loadCustomerTaskPortModel.getCustomer().getStrasse());
        assertEquals("strassenZusatz", loadCustomerTaskPortModel.getCustomer().getStrassenzusatz());
        assertEquals("ort", loadCustomerTaskPortModel.getCustomer().getOrt());
        assertEquals("land", loadCustomerTaskPortModel.getCustomer().getLand());
        assertEquals("plz", loadCustomerTaskPortModel.getCustomer().getPlz());
        assertEquals("firma", loadCustomerTaskPortModel.getCustomer().getFirmenName());
    }





}