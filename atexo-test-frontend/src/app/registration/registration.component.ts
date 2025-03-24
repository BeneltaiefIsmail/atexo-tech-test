import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {RegistrationService} from '../services/registration.service';
import {Registration} from '../model/registration';

// @ts-ignore
@Component({
  selector: 'app-registration',
  standalone: false,
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  registrationForm!:FormGroup;
  constructor(private fb: FormBuilder, private registrationService: RegistrationService) {
    this.registrationForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      birthDate: ['', Validators.required]
    });
  }



  saveRegisration() {

    if (this.registrationForm.valid) {
      const registration: Registration = this.registrationForm.value;

      this.registrationService.saveRegistration(registration).subscribe({
        next: (response) => {
          console.log('Utilisateur enregistré avec succès', response);
          alert('Inscription réussie !');
          this.registrationForm.reset();
        },
        error: (error) => {
          console.error('Erreur lors de l\'inscription', error);
          alert('Erreur lors de l\'inscription');
        }
      });
    }
  }
}
