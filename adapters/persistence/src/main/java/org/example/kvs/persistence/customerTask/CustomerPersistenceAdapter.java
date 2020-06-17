package org.example.kvs.persistence.customerTask;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.PersistenceAdapter;
import org.example.kvs.persistence.repositories.CustomerJpaRepository;
import org.example.kvs.persistence.repositories.CustomerTaskJpaRepository;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@PersistenceAdapter
class CustomerPersistenceAdapter implements LoadCustomerPort, LoadCustomerTaskPort{

    final CustomerJpaRepository customerJpaRepository;
    final CustomerTaskJpaRepository customerTaskJpaRepository;

    @Override
    public LoadCustomerPortModel loadCustomerById(int id) {
        return map(customerJpaRepository.findById(id));
    }

    private LoadCustomerPortModel map(Optional<CustomerJpaRepository.CustomerJpaEntity> toMap) {
        CustomerJpaRepository.CustomerJpaEntity entity = toMap.get();
        return new LoadCustomerPortModel(entity.getId(), entity.getVorname(), entity.getNachname(), entity.getEmail(), entity.getStrasse(), entity.getStrassenzusatz(), entity.getOrt(), entity.getLand(), entity.getPlz(), entity.getFirmenName());
    }

    @Override
    public List<LoadCustomerTaskPortModel> loadCustomerTasksByLastChange() {
        //TODO
        return null;
    }


}
