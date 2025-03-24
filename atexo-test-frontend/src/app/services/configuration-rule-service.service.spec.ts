import { TestBed } from '@angular/core/testing';

import { ConfigurationRuleServiceService } from './configuration-rule-service.service';

describe('ConfigurationRuleServiceService', () => {
  let service: ConfigurationRuleServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfigurationRuleServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
