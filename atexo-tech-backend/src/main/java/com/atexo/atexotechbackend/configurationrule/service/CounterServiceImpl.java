package com.atexo.atexotechbackend.configurationrule.service;

import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.entity.Counter;
import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import com.atexo.atexotechbackend.configurationrule.repository.CounterRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class CounterServiceImpl implements CounterService{

    private final CounterRepository counterRepository;
    private final ConfigurationRuleRepository configurationRuleRepository;
    @Autowired
    public CounterServiceImpl(CounterRepository counterRepository, ConfigurationRuleRepository configurationRuleRepository) {
        this.counterRepository = counterRepository;
        this.configurationRuleRepository = configurationRuleRepository;
    }
    /**
     * @return => Int value of the counter that will be used in generating Unique identifier ID
     */
    @Override
    public int getNextCounter() {
        log.info("getNextCounter: Starting method getting Next counter");
        // get the actual counter if not exist => we have to get the Initial value from
        // the Configuration table and increment it => and save it in a table COUNTER
        // that contain one line
        Counter counter = counterRepository.findById(1L)
                                 .orElseGet(this::intiliazeCounterValue);
        int actualValue = counter.getCurrentCounterValue() + 1;
        log.debug("getNextCounter: new value is {}", actualValue);
        counter.setCurrentCounterValue(actualValue);
        counterRepository.save(counter);
        return actualValue;
    }
    /**
     * //Method for initiliazing the counter Value
     * @return => initial value
     */
    private Counter intiliazeCounterValue() {
        ConfigurationRule configurationRule = configurationRuleRepository.findByCriteriaType(CriteriaType.COUNTER);
        if (configurationRule == null) {
            throw new IllegalStateException("Counter configuration rule not found");
        }
        return new Counter(configurationRule.getInitialValue());
    }
}
