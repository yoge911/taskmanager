import { Component, OnInit } from '@angular/core';
import { TaskingService } from "../tasking.service";
import { switchMap, map } from 'rxjs/operators';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

    datas:any;
   
    
    constructor(private taskingService:TaskingService) {
        
        this.taskingService.getTask().subscribe(res =>  {this.datas = res;});
        
        
    }

  ngOnInit() {


  }

  doTextareaValueChange(ev) {
    try {
      this.datas.description = ev.target.value;
    } catch(e) {
      console.info('could not set textarea-value');
    }

  }

}
