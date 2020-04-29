import { Component, OnInit } from '@angular/core';
import { Virus } from '../virus';
import { ViralServiceService } from '../viral-service.service';

@Component({
  selector: 'app-virus-list',
  templateUrl: './virus-list.component.html',
  styleUrls: ['./virus-list.component.css']
})
export class VirusListComponent implements OnInit {
  viruses: Virus[];
 
  constructor(private viralService: ViralServiceService) {
  }
 
  ngOnInit() {
    this.viralService.findAll().subscribe(data => {
      this.viruses = data;
    });
  }

}
