import { Component, OnInit } from '@angular/core';
import { TaskingService } from "../tasking.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks:any[];
  constructor(private taskingService:TaskingService, private router:Router) {
      this.taskingService.getTasks().subscribe((data : any[]) => this.tasks = data);
  }

  ngOnInit() {

  }

  loadTask(id){
      this.taskingService.taskID = id;
      this.router.navigate(['task']);
  }



}
