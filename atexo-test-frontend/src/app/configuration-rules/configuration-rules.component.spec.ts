import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigurationRulesComponent } from './configuration-rules.component';

describe('ConfigurationRulesComponent', () => {
  let component: ConfigurationRulesComponent;
  let fixture: ComponentFixture<ConfigurationRulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ConfigurationRulesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfigurationRulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
