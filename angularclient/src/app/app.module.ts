import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { VirusListComponent } from './virus-list/virus-list.component';
import { VirusFormComponent } from './virus-form/virus-form.component';
import { ViralServiceService } from './viral-service.service';
import { CheckSignComponent } from './check-sign/check-sign.component';

@NgModule({
  declarations: [
    AppComponent,
    VirusListComponent,
    VirusFormComponent,
    CheckSignComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ViralServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
