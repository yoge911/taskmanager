import { TestBed, inject } from '@angular/core/testing';

import { TaskingService } from './tasking.service';

describe('TaskingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TaskingService]
    });
  });

  it('should be created', inject([TaskingService], (service: TaskingService) => {
    expect(service).toBeTruthy();
  }));
});
