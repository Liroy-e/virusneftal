import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VirusListComponent } from './virus-list/virus-list.component';
import { VirusFormComponent } from './virus-form/virus-form.component';
import { CheckSignComponent } from './check-sign/check-sign.component';
 

const routes: Routes = [
  { path: 'viruses', component: VirusListComponent },
  { path: 'addvirus', component: VirusFormComponent },
  { path: 'check', component: CheckSignComponent }
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }