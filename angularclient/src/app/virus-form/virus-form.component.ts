import { Component, OnInit } from '@angular/core';
import { Virus } from '../virus';
import { ViralServiceService } from '../viral-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-virus-form',
  templateUrl: './virus-form.component.html',
  styleUrls: ['./virus-form.component.css']
})
export class VirusFormComponent  {

  virus: Virus;
 
  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private virusService: ViralServiceService) {
    this.virus = new Virus();
  }
 
  onSubmit() {
    this.virusService.save(this.virus).subscribe(result => this.gotoUserList());
  }
  
  onDelete() {
    this.virusService.delete(this.virus).subscribe(result => this.gotoUserList());
  }
 
  gotoUserList() {
    this.router.navigate(['/viruses']);
  }
}
