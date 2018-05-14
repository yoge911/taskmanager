import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, interval, pipe } from 'rxjs';
import { switchMap, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class TaskingService {

  taskID:String;
  constructor( private http : HttpClient) {

  }


getTask(){
    return this.http.get('http://localhost:8080/tasks/' + this.taskID);
}
  getTasks(){        
    
   //return interval(1000).flatmap((i) => this.http.get('http://localhost:8080/tasks'))  
   //return this.http.get('http://localhost:8080/tasks');
    return interval(1000).pipe(
    switchMap(() => this.http.get('http://localhost:8080/tasks')
    ));


  }


}
