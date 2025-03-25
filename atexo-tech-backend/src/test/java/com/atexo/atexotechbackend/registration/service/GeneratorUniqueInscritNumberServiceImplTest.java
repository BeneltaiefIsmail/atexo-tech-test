package com.atexo.atexotechbackend.registration.service;

import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.entity.CriteriaType;
import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import com.atexo.atexotechbackend.configurationrule.service.CounterService;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueInscritNumberServiceImpl;
import com.atexo.atexotechbackend.registration.service.generetoruniquenumber.GeneratorUniqueNumberParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GeneratorUniqueInscritNumberServiceImplTest {
    @Mock
    private ConfigurationRuleRepository configurationRuleRepository;
    @Mock
    private CounterService counterService;

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
    void generateUniqueIdNoConfigurationRule() {
        // config vide
        Mockito.when(configurationRuleRepository.findAllByOrderByRankAsc()).thenReturn(List.of());
        String result = service.genrateUniqueInscritNumber(param);
        Assertions.assertEquals("No configuration rules found", result);
    }
    @Test
    void generateUniqueIdFirstNameCriteria () {
        ConfigurationRule rule = new ConfigurationRule();
        rule.setCriteriaType(CriteriaType.FIRST_NAME);
        rule.setLength(3);
        rule.setPrefix("_");
        rule.setSuffix("_");
        Mockito.when(configurationRuleRepository.findAllByOrderByRankAsc()).thenReturn(List.of(rule));
        String result = service.genrateUniqueInscritNumber(param);
        Assertions.assertEquals("_MAR_", result);
    }
    @Test
    void generateUniqueIdLastNameCriteria () {
        ConfigurationRule rule = new ConfigurationRule();
        rule.setCriteriaType(CriteriaType.LAST_NAME);
        rule.setLength(4);  // Prenons les 4 premiers caractères
        rule.setPrefix("/*");
        rule.setSuffix("*/");
        Mockito.when(configurationRuleRepository.findAllByOrderByRankAsc()).thenReturn(List.of(rule));
        String result = service.genrateUniqueInscritNumber(param);
        Assertions.assertEquals("/*PASS*/", result);
    }
    @Test
    void generateUniqueIdBirthDateCriteria () {
        ConfigurationRule rule = new ConfigurationRule();
        rule.setCriteriaType(CriteriaType.DATE_OF_BIRTH);
        rule.setDateFormat("YYYY");
        rule.setPrefix("DAT_");
        rule.setSuffix("&&");
        Mockito.when(configurationRuleRepository.findAllByOrderByRankAsc()).thenReturn(List.of(rule));
        String result = service.genrateUniqueInscritNumber(param);
        Assertions.assertEquals("DAT_1974&&", result);
    }
    @Test
    void generateUniqueIdCounterCriteria () {
        ConfigurationRule rule = new ConfigurationRule();
        rule.setCriteriaType(CriteriaType.COUNTER);
        rule.setLength(8);
        rule.setPrefix(" ");
        rule.setSuffix("=>CPT");
        Mockito.when(configurationRuleRepository.findAllByOrderByRankAsc()).thenReturn(List.of(rule));
        Mockito.when(counterService.getNextCounter()).thenReturn(123);
        String result = service.genrateUniqueInscritNumber(param);
        Assertions.assertEquals(" 00000124=>CPT", result);
    }

}
