package com.atexo.atexotechbackend.registration.service.generetoruniquenumber;

import com.atexo.atexotechbackend.common.util.StringUtil;
import com.atexo.atexotechbackend.configurationrule.entity.ConfigurationRule;
import com.atexo.atexotechbackend.configurationrule.repository.ConfigurationRuleRepository;
import com.atexo.atexotechbackend.registration.execption.UniqueNumberGeneratorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class GeneratorUniqueInscritNumberServiceImpl implements GeneratorUniqueInscritNumberService {

    private final ConfigurationRuleRepository configurationRuleRepository;
    @Autowired
    public GeneratorUniqueInscritNumberServiceImpl(ConfigurationRuleRepository configurationRuleRepository) {
        this.configurationRuleRepository = configurationRuleRepository;
    }
    /**
     * @param param@return
     */
    @Override
    public String genrateUniqueInscritNumber(GeneratorUniqueNumberParam param) {
        //
        //1- Load Configuration Rule Ordered By Rank
        //
           List<ConfigurationRule> configurationRules = configurationRuleRepository.findAllByOrderByRankAsc();
           if  (configurationRules.isEmpty()) {
               return new UniqueNumberGeneratorException("No configuration rules found").toString();
           }
        //
        //3- Generate Unique Inscrit Number
        //
        StringBuilder uniqueInscritNumber = new StringBuilder();
        configurationRules.forEach(configurationRule -> {
            uniqueInscritNumber.append(checkRule (configurationRule , param));
        });
        return uniqueInscritNumber.toString();
    }
    /**
     *
     * @param configurationRule
     * @param param
     * @return
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
     * @param firstName
     * @param configurationRule
     * @return
     */
    private String checkRuleFirstName(String firstName, ConfigurationRule configurationRule) {
        if (firstName == null || firstName.isEmpty()) {
            return "";
        }
        int length = configurationRule.getLength();
        String suffixe = configurationRule.getSuffix();
        String prefixe = configurationRule.getPrefix();
        //
        String firstNameTruncated = StringUtil.safeSubString(firstName, 0, length);
        StringBuilder result = new StringBuilder();
        result.append(suffixe).append(firstNameTruncated).append(suffixe);
        return result.toString();
    }

    /**
     *
     * @param lastName
     * @param configurationRule
     * @return
     */
     private String checkRuleLastName (String lastName , ConfigurationRule configurationRule) {
         if (lastName == null || lastName.isEmpty()) {
             return "";
         }
         int length = configurationRule.getLength();
         String suffixe = configurationRule.getSuffix();
         String prefixe = configurationRule.getPrefix();
         //
         String lastNameTruncated = StringUtil.safeSubString (lastName , 0 , length) ;
         StringBuilder result = new StringBuilder();
         result.append(prefixe).append(lastNameTruncated).append(suffixe);
         return result.toString();
     }

    /**
     *
     * @param dateOfBirth
     * @param configurationRule
     * @return
     */
     private String checkRuleDateOfBirth (LocalDate dateOfBirth , ConfigurationRule configurationRule) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(configurationRule.getDateFormat());
         return configurationRule.getPrefix()
                 + dateOfBirth.format(formatter)
                 + configurationRule.getSuffix();
     }

    /**
     *
     * @param configurationRule
     * @return
     */
    // TODO
     private String checkRuleCounter ( ConfigurationRule configurationRule) {
     //    String formattedCounter = String.format("%05d", counter.getAndIncrement());
         return configurationRule.getPrefix()
              //   + formattedCounter
                 + configurationRule.getSuffix();
     }
}
