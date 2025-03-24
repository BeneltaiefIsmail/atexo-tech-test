package com.atexo.atexotechbackend.registration.service;

import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueInscritNumberServiceImpl;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueNumberParam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GeneratorUniqueInscritNumberServiceImplTest {
    @Mock
    private ConfigurationRuleRepository configurationRuleRepository;

    @InjectMocks
    private GeneratorUniqueInscritNumberServiceImpl service;
    private GeneratorUniqueNumberParam param ;
    private static final String FIRST_NAME_TEST = "MARC";
    private static final String LAST_NAME_TEST = "PASSAU";
    private static final LocalDate BIRTH_DATE_TEST = LocalDate.of(1974, 4  , 24);

    @BeforeEach
    void setUp() {
        param = new GeneratorUniqueNumberParam(
                FIRST_NAME_TEST,
                LAST_NAME_TEST,
                BIRTH_DATE_TEST
        );
    }
    @Test
    void generateUniqueId_NoConfigurationRule() {
    }
    @Test
    void generateUniqueId_FirstNameCriteria () {
    }
    @Test
    void generateUniqueId_LastNameCriteria () {
    }
    @Test
    void generateUniqueId_BirthDateCriteria () {
    }
    @Test
    void generateUniqueId_CounterCriteria () {
    }

}
