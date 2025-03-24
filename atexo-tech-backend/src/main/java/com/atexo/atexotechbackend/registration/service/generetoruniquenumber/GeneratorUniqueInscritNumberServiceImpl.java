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
import java.util.Objects;

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
        String prefixe = Objects.toString(configurationRule.getPrefix(), "");
        String suffixe = Objects.toString(configurationRule.getSuffix(), "");
        String firstNameTruncated = StringUtil.safeSubString(firstName, 0, length);
         return prefixe + firstNameTruncated + suffixe;
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
         String prefixe = Objects.toString(configurationRule.getPrefix(), "");
         String suffixe = Objects.toString(configurationRule.getSuffix(), "");
         String lastNameTruncated = StringUtil.safeSubString (lastName , 0 , length) ;
         return prefixe + lastNameTruncated + suffixe;
     }
    /**
     *
     * @param dateOfBirth
     * @param configurationRule
     * @return
     */
     private String checkRuleDateOfBirth (LocalDate dateOfBirth , ConfigurationRule configurationRule) {
         String dateFormat = configurationRule.getDateFormat();
         if (dateFormat == null || dateFormat.isEmpty()) {
             return "" ;
         }
         String prefix = Objects.toString(configurationRule.getPrefix(), "");
         String suffix = Objects.toString(configurationRule.getSuffix(), "");
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(configurationRule.getDateFormat());
         return prefix + dateOfBirth.format(formatter) + suffix;
     }
    /**
     *
     * @param configurationRule
     * @return
     */
    // TODO
     private String checkRuleCounter ( ConfigurationRule configurationRule) {
         return configurationRule.getPrefix()
              //   + formattedCounter
                 + configurationRule.getSuffix();
     }
}
