import { Component, OnInit } from '@angular/core';
import { Virus } from '../virus';
import { ViralServiceService } from '../viral-service.service';


@Component({
  selector: 'app-check-sign',
  templateUrl: './check-sign.component.html',
  styleUrls: ['./check-sign.component.css']
})
export class CheckSignComponent {


  currentFileUpload: File;
  neutre: String;
  bad: String;
  safe: String;
  sign: String;

  constructor( 
        private virusService: ViralServiceService) {
          this.sign=new String();
  }


  public onFileChanged(event) {
    //Select File
    this.currentFileUpload = event.target.files[0];
  }


  upload() {
    console.log(this.currentFileUpload);
    document.getElementById('gif').className = "hideMe";
    setTimeout(() => {  document.getElementById('gif').className = "hidden"; }, 2300);
    this.virusService.pushFileToCheck(this.currentFileUpload).subscribe((response) => {
      if (response.status === 200) {
        this.getCheckResult();
      } else {
        console.log('Not uploaded successfully');
      }});
    
  }

  sendSign(str : String) {
    document.getElementById('gif').className = "hideMe";
    setTimeout(() => {  document.getElementById('gif').className = "hidden"; }, 2300);
    console.log(str);
    this.virusService.checkS(str).subscribe((response) => {
      if (response.status === 200) {
        this.getCheckResult();
      } else {
        console.log('Not successful');
      }});


  }

  getCheckResult(){
    this.virusService.getChecker().subscribe(x => {
      console.log(x);
        if(x=="unkown"){ this.neutre="This Signature is unkown to the DB/VirusTotal";
                          this.safe=undefined;this.bad=undefined;}
        else if(x=="safe"){ this.safe="Its Safe.";
                              this.bad=undefined;this.neutre=undefined;  }
        else if(x=="dangerous"){ this.bad="Its Dangerous!";
                               this.safe=undefined; this.neutre=undefined;}
        else{
          alert("Request failed");
        }
    });
  }
    
}
