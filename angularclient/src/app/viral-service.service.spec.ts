import { TestBed } from '@angular/core/testing';

import { ViralServiceService } from './viral-service.service';

describe('ViralServiceService', () => {
  let service: ViralServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViralServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
