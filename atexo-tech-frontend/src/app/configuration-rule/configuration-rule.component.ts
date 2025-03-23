import { Component } from '@angular/core';
interface RuleSection {
  suffixe: string;
  prefixe: string;
  ordre: number | null;
  longueur?: number | null;
  format?: string;
  valeurInitiale?: number | null;
}

@Component({
  selector: 'app-configuration-rule',
  imports: [],
  templateUrl: './configuration-rule.component.html',
  styleUrl: './configuration-rule.component.css'
})
export class ConfigurationRuleComponent {
  formData = {
    FIRST_NAME: {
      longueur: null,
      suffixe: '',
      prefixe: '',
      ordre: null
    } as RuleSection,
    LAST_NAME: {
      longueur: null,
      suffixe: '',
      prefixe: '',
      ordre: null
    } as RuleSection,
    DATE_OF_BIRTH: {
      format: '',
      suffixe: '',
      prefixe: '',
      ordre: null
    } as RuleSection,
    COUNTER: {
      longueur: null,
      suffixe: '',
      prefixe: '',
      valeurInitiale: null,
      ordre: null
    } as RuleSection
  };
}
