import { TestBed } from '@angular/core/testing';

import { MliotServiceService } from './mliot-service.service';

describe('MliotServiceService', () => {
  let service: MliotServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MliotServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
