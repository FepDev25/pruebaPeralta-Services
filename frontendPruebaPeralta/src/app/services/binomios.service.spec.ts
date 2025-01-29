import { TestBed } from '@angular/core/testing';

import { BinomiosService } from './binomios.service';

describe('BinomiosService', () => {
  let service: BinomiosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BinomiosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
