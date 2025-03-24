import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ConfigurationRuleServiceService} from '../services/configuration-rule-service.service';
import {ConfigurationRule, ConfigurationRulePayload} from '../model/configuration';

@Component({
  selector: 'app-configuration-rules',
  standalone: false,
  templateUrl: './configuration-rules.component.html',
  styleUrl: './configuration-rules.component.css'
})
export class ConfigurationRulesComponent {

  configurationForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private configurationRuleService: ConfigurationRuleServiceService
  ) {
    this.configurationForm = this.fb.group({
      firstName: this.fb.group({
        length: [ '', Validators.required],
        prefix: ['', Validators.required],
        suffix: ['', Validators.required],
        rank: ['', Validators.required]
      }),
      lastName: this.fb.group({
        length: ['', Validators.required],
        prefix: ['', Validators.required],
        suffix: ['', Validators.required],
        rank: ['', Validators.required]
      }),
      dateOfBirth: this.fb.group({
        dateFormat: ['', Validators.required],
        prefix: ['', Validators.required],
        suffix: ['', Validators.required],
        rank: ['', Validators.required]
      }),
      counter: this.fb.group({
        length: ['', Validators.required],
        prefix: ['', Validators.required],
        suffix: ['', Validators.required],
        initialValue: ['', Validators.required],
        rank: ['', Validators.required]
      })
    });
  }

  saveConfiguration() {
    if (this.configurationForm.valid) {
      const payload: ConfigurationRulePayload = {
        configurationRuleDtos: [
          {
            criteriaType: 'FIRST_NAME',
            length: this.configurationForm.value.firstName.length,
            prefix: this.configurationForm.value.firstName.prefix,
            suffix: this.configurationForm.value.firstName.suffix,
            dateFormat: null,
            rank: this.configurationForm.value.firstName.rank,
            initialValue: null
          },
          {
            criteriaType: 'LAST_NAME',
            length: this.configurationForm.value.lastName.length,
            prefix: this.configurationForm.value.lastName.prefix,
            suffix: this.configurationForm.value.lastName.suffix,
            dateFormat: null,
            rank: this.configurationForm.value.lastName.rank,
            initialValue: null
          },
          {
            criteriaType: 'DATE_OF_BIRTH',
            length: null,
            prefix: this.configurationForm.value.dateOfBirth.prefix,
            suffix: this.configurationForm.value.dateOfBirth.suffix,
            dateFormat: this.configurationForm.value.dateOfBirth.dateFormat,
            rank: this.configurationForm.value.dateOfBirth.rank,
            initialValue: null
          },
          {
            criteriaType: 'COUNTER',
            length: this.configurationForm.value.counter.length,
            prefix: this.configurationForm.value.counter.prefix,
            suffix: this.configurationForm.value.counter.suffix,
            dateFormat: null,
            rank: this.configurationForm.value.counter.rank,
            initialValue: this.configurationForm.value.counter.initialValue
          }
        ]
      };

      this.configurationRuleService.saveConfigurationRule(payload).subscribe({
        next: (response) => {
          console.log('Configuration enregistrée', response);
          alert('Succès !');
        },
        error: (error) => {
          console.error('Erreur', error);
          alert('Échec de l\'enregistrement');
        }
      });
    }
  }
}
