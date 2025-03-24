import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ConfigurationRuleServiceService} from '../services/configuration-rule-service.service';
import {ConfigurationRule} from '../model/configuration';

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
      prenomLongueur: ['', Validators.required],
      prenomPrefixe: ['', Validators.required],
      prenomSuffixe: ['', Validators.required],
      prenomOrdre: ['', Validators.required],
      nomLongueur: ['', Validators.required],
      nomPrefixe: ['', Validators.required],
      nomSuffixe: ['', Validators.required],
      nomOrdre: ['', Validators.required],
      dateNaissanceFormat: ['', Validators.required],
      dateNaissancePrefixe: ['', Validators.required],
      dateNaissanceSuffixe: ['', Validators.required],
      dateNaissanceOrdre: ['', Validators.required],
      compteurLongueur: ['', Validators.required],
      compteurPrefixe: ['', Validators.required],
      compteurSuffixe: ['', Validators.required],
      compteurValeurInitiale: ['', Validators.required],
      compteurOrdre: ['', Validators.required]
    });
  }

  saveConfiguration() {
    if (this.configurationForm.valid) {
      const configurationRule:ConfigurationRule = this.configurationForm.value;
      this.configurationRuleService.saveConfigurationRule(configurationRule).subscribe({
        next: (response) => {
          console.log('Configuration enregistrée avec succès', response);
          alert('Configuration réussie !');
          this.configurationForm.reset();
        },
        error: (error) => {
          console.error('Erreur lors de l\'enregistrement de la configuration', error);
          alert('Erreur lors de l\'enregistrement de la configuration');
        }
      });
    }
  }
}
