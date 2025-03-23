import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigurationRuleComponent } from './configuration-rule.component';

describe('ConfigurationRuleComponent', () => {
  let component: ConfigurationRuleComponent;
  let fixture: ComponentFixture<ConfigurationRuleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfigurationRuleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfigurationRuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
