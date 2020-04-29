import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest } from '@angular/common/http';
import { Virus } from './virus';
import { Observable } from 'rxjs';

@Injectable()
export class ViralServiceService {

  private usersUrl: string;
  private checkerUrl:string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8081/viruses';
    this.checkerUrl = 'http://localhost:8082';
  }
 
  public findAll(): Observable<Virus[]> {
    return this.http.get<Virus[]>(this.usersUrl);
  }
 
  public save(virus: Virus) {
    return this.http.post<Virus>(this.usersUrl, virus);
  }

  public delete(virus: Virus) {
    return this.http.delete<Virus>(this.usersUrl+"/"+virus.signature);
  }


  public pushFileToCheck(file: File) {
    const data: FormData = new FormData();
    data.append('file', file);
    return this.http.post(this.checkerUrl, data, { observe: 'response' });
  }

  public getChecker():Observable<String> {
    let data = this.http.get(this.checkerUrl,{responseType: 'text'});
    return data;
  }

  public checkS(str: String){
    return this.http.get(this.checkerUrl+"/"+str, { observe: 'response' });
  }

}
