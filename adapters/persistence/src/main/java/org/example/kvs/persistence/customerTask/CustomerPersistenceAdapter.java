package org.example.kvs.persistence.customerTask;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.PersistenceAdapter;
import org.example.kvs.persistence.repositories.CustomerJpaRepository;
import org.example.kvs.persistence.repositories.CustomerTaskJpaRepository;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.util.List;


@RequiredArgsConstructor
@PersistenceAdapter
class CustomerPersistenceAdapter implements LoadCustomerPort, LoadCustomerTaskPort{

    final CustomerJpaRepository customerJpaRepository;
    final CustomerTaskJpaRepository customerTaskJpaRepository;

    @Override
    public LoadCustomerPortModel loadCustomerById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<LoadCustomerTaskPortModel> loadCustomerTasksByLastChange() {
        //TODO
        return null;
    }


}
