package com.atexo.atexotechbackend.settingcriteria;

import com.atexo.atexotechbackend.registrant.controller.RegistrantController;
import com.atexo.atexotechbackend.registrant.service.RegistrantService;
import com.atexo.atexotechbackend.settingcriteria.controller.CriteriaConfigController;
import com.atexo.atexotechbackend.settingcriteria.service.CriteriaConfigService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CriteriaConfigControllerTest {



    @Mock
    private CriteriaConfigService criteriaConfigService  ; // Simule le service

    @InjectMocks
    private CriteriaConfigController criteriaConfigController; // Contrôleur à tester

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialise les mocks
    }
}
