package com.atexo.atexotechbackend.configurationrule;

import com.atexo.atexotechbackend.configurationrule.controller.ConfigRuleController;
import com.atexo.atexotechbackend.configurationrule.service.ConfigurationRuleService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConfigurationRuleControllerTest {



    @Mock
    private ConfigurationRuleService configurationRuleService; // Simule le service

    @InjectMocks
    private ConfigRuleController configRuleController; // Contrôleur à tester

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks
    }
}
