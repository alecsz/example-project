package org.example.kvs.persistence.customerTask;

import lombok.RequiredArgsConstructor;
import org.example.kvs.common.PersistenceAdapter;
import org.example.kvs.persistence.repositories.CustomerJpaRepository;
import org.example.kvs.persistence.repositories.CustomerTaskJpaRepository;
import org.example.kvs.port.out.persistence.LoadCustomerPort;
import org.example.kvs.port.out.persistence.LoadCustomerTaskPort;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@PersistenceAdapter
class CustomerPersistenceAdapter implements LoadCustomerPort, LoadCustomerTaskPort{

    final CustomerJpaRepository customerJpaRepository;
    final CustomerTaskJpaRepository customerTaskJpaRepository;

    @Override
    public LoadCustomerPortModel loadCustomerById(int id) {
        return map(customerJpaRepository.findById(id));
    }

    @Override
    public List<LoadCustomerTaskPortModel> loadCustomerTasksByLastChange(LocalDateTime dateTime) {
        return customerTaskJpaRepository.findByLastChangeGreaterThan(Timestamp.valueOf(dateTime)).stream().map(this::mapToCustomerTaskPortModel).collect(Collectors.toList());
    }

    @Override
    public LoadCustomerTaskPortModel loadCustomerTaskById(int id) {
        return mapToCustomerTaskPortModel(customerTaskJpaRepository.findById(String.valueOf(id)));
    }

    protected LoadCustomerTaskPortModel mapToCustomerTaskPortModel(Optional<CustomerTaskJpaRepository.CutomerTaskJpaEntity> toMap) {
        CustomerTaskJpaRepository.CutomerTaskJpaEntity entity = toMap.orElse(null);
        return mapToCustomerTaskPortModel(entity);
    }

    protected LoadCustomerTaskPortModel mapToCustomerTaskPortModel(CustomerTaskJpaRepository.CutomerTaskJpaEntity entity) {
        assert entity != null;
        return new LoadCustomerTaskPortModel(entity.getId(), entity.getArtikelNummer(), entity.getCreated().toLocalDateTime(), entity.getLastChange().toLocalDateTime(), map(entity.getCustomer()));
    }

    protected LoadCustomerPortModel map(CustomerJpaRepository.CustomerJpaEntity entity) {
        return new LoadCustomerPortModel(entity.getId(), entity.getVorname(), entity.getNachname(), entity.getEmail(), entity.getStrasse(), entity.getStrassenzusatz(), entity.getOrt(), entity.getLand(), entity.getPlz(), entity.getFirmenName());
    }

    protected LoadCustomerPortModel map(Optional<CustomerJpaRepository.CustomerJpaEntity> toMap) {
        CustomerJpaRepository.CustomerJpaEntity entity = toMap.orElse(null);
        assert entity != null;
        return map(entity);
    }


}
