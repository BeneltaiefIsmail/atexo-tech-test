package com.atexo.atexotechbackend.registration.service.generetoruniquenumber;

import com.atexo.atexotechbackend.common.util.StringUtil;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import com.atexo.atexotechbackend.configurationrule.service.CounterService;
import com.atexo.atexotechbackend.registration.execption.UniqueNumberGeneratorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * Author : Isb
 * Date : 24/03/2025
 * Service Classe for generation Unique identifier Numbercs
 */
@Service
@Slf4j
public class GeneratorUniqueInscritNumberServiceImpl implements GeneratorUniqueInscritNumberService {

    private final ConfigurationRuleRepository configurationRuleRepository;
    private final CounterService counterService ;
    @Autowired
    public GeneratorUniqueInscritNumberServiceImpl(ConfigurationRuleRepository configurationRuleRepository, CounterService counterService) {
        this.configurationRuleRepository = configurationRuleRepository;
        this.counterService = counterService;
    }
    /**
     * This method encapsulate steps of  the logical busness for Generating UniqueIdentifier
     * @param param
     *            a new Class that contain (firstName , LastName , DateOfBirth) the Criteria
     * @return
     *        String value = UniqueIdentifier
     */
    @Override
    public String genrateUniqueInscritNumber(GeneratorUniqueNumberParam param) {
        log.info("Begin -> genrateUniqueInscritNumber: Starting method for Generationg UniqueIdentifier ");
        //1- Load Configuration Rule Ordered By Rank
           List<ConfigurationRule> configurationRules = configurationRuleRepository.findAllByOrderByRankAsc();
           if  (configurationRules.isEmpty()) {
               return new UniqueNumberGeneratorException("No configuration rules found").toString();
           }
        //2- Generate Unique Inscrit Number
        StringBuilder uniqueInscritNumber = new StringBuilder();
        configurationRules.forEach(configurationRule -> {
            uniqueInscritNumber.append(checkRule (configurationRule , param));
        });
        log.debug("genrateUniqueInscritNumber : value {}", uniqueInscritNumber);
        return uniqueInscritNumber.toString();
    }
    /**
     *
     * @param
     *       configurationRule
     * @param
     *       param
     * @return
     *       return a String that contain the Unique Inscrit Number Identifier
     */
     private String checkRule(ConfigurationRule configurationRule, GeneratorUniqueNumberParam param) {
        switch (configurationRule.getCriteriaType()) {
            case FIRST_NAME -> {
                return checkRuleFirstName (param.getFirstName() , configurationRule) ;
            }
            case LAST_NAME -> {
                return checkRuleLastName (param.getLastName() , configurationRule) ;
            }
            case DATE_OF_BIRTH -> {
                return checkRuleDateOfBirth(param.getDateOfBirth() , configurationRule) ;
            }
            case COUNTER -> {
                return checkRuleCounter( configurationRule) ;
            }
            default -> throw new UniqueNumberGeneratorException("the rule is unsupported" + configurationRule.getCriteriaType());
        }
     }

    /**
     *
     * @param
     *       firstName
     * @param
     *       configurationRule
     * @return
     *       a new string value that contain the transcod for the firstName Criteria
     * =>1- Using a méthod SafeSubString to get the truncated value
     * =>2- concat prefix , transcod first name , suffixe
     */
    private String checkRuleFirstName(String firstName, ConfigurationRule configurationRule) {
        log.info("Begin -> checkRuleFirstName: Starting method for cheking firstName " + firstName);
        if (firstName == null || firstName.isEmpty()) return "";
        int length = configurationRule.getLength();
        String prefixe = Objects.toString(configurationRule.getPrefix(), "");
        String suffixe = Objects.toString(configurationRule.getSuffix(), "");
        String firstNameTruncated = StringUtil.safeSubString(firstName, 0, length);
        log.debug("firstNameTruncated: " + firstNameTruncated);
        return prefixe + firstNameTruncated + suffixe;

    }
    /**
     *
     * @param
     *       lastName
     * @param
     *       configurationRule
     * @return
     *       a new string value that contain the transcod for the LastName Criteria
     * =>1- Using a méthod SafeSubString to get the truncated value
     * =>2- concat prefix , transcod LastName , suffixe
     */
     private String checkRuleLastName (String lastName , ConfigurationRule configurationRule) {
         log.info("Begin -> checkRuleFirstName: Starting method for cheking lastName " + lastName);
         if (lastName == null || lastName.isEmpty()) return "";
         int length = configurationRule.getLength();
         String prefixe = Objects.toString(configurationRule.getPrefix(), "");
         String suffixe = Objects.toString(configurationRule.getSuffix(), "");
         String lastNameTruncated = StringUtil.safeSubString (lastName , 0 , length) ;
         log.debug("lastNameTruncated: " + lastNameTruncated);
         return prefixe + lastNameTruncated + suffixe;
     }

    /**
     *
     * @param
     *       dateOfBirth
     * @param
     *       configurationRule
     * @return
     *       a new string value that contain the transcod for the Birth Date Criteria
     *=> 1- Using a méthod to foramt date to get the new dateformat value
     *=> 2- concat prefix , transcod date , suffixe
     *
     */
     private String checkRuleDateOfBirth (LocalDate dateOfBirth , ConfigurationRule configurationRule) {
         log.info("Begin -> checkRuleFirstName: Starting method for cheking dateOfBirth " + dateOfBirth);
         String dateFormat = configurationRule.getDateFormat();
         if (dateFormat == null || dateFormat.isEmpty()) {
             return "" ;
         }
         String prefix = Objects.toString(configurationRule.getPrefix(), "");
         String suffix = Objects.toString(configurationRule.getSuffix(), "");
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(configurationRule.getDateFormat());
         log.debug("dateFormat: " + dateFormat);
         return prefix + dateOfBirth.format(formatter) + suffix;
     }
    /**
     * @param
     *       configurationRule
     * @return
     *      a new string value that contain the transcod for the counter Criteria
     *=> 1- Using a méthod to foramt counter to get the new counter value
     *=> 2- concat prefix , transcod counter , suffixe
     */
     private String checkRuleCounter ( ConfigurationRule configurationRule) {
         log.info("Begin -> checkRuleFirstName: Starting method for cheking counter");
         int length = configurationRule.getLength();
         String prefix = Objects.toString(configurationRule.getPrefix(), "");
         String suffix = Objects.toString(configurationRule.getSuffix(), "");
         Integer counterValue = counterService.getNextCounter();
         String formattedCounter;
         if (!(length == 0)) {
             formattedCounter = String.format("%0" + length + "d", counterValue);
         }
         else {
             formattedCounter = counterValue.toString();
         }
         log.debug("formattedCounter: " + formattedCounter);
         return prefix + formattedCounter + suffix ;
     }
}
