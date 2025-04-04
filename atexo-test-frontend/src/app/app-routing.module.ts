import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { ConfigurationRulesComponent } from './configuration-rules/configuration-rules.component';



const routes: Routes = [
  {path : "inscription" , component : RegistrationComponent} ,
  {path : "configuration-rules" , component: ConfigurationRulesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
