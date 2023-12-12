import { HttpClient } from '@angular/common/http';
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MfeConfigModel } from 'src/app/shared/models/mfe-config.model';
import { ApiService } from './shared/services/api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnChanges {
  @Input() config!: string;
  public formBuilderObject: FormGroup = new FormGroup({
    entandoForm: new FormControl('', [Validators.required]),
  });
  public form: Object = {
    components: [],
  };

  private configParsed: MfeConfigModel;

  constructor(private apiService: ApiService) {}

  ngOnChanges(changes: SimpleChanges) {
    if (changes['config']) {
      this.configParsed = JSON.parse(this.config);
      this.apiService.config = this.configParsed;
    }
  }

  public onChange(event): void {
    this.formBuilderObject.get('entandoForm').setValue(event.form);
  }

  public onSaveForm(): void {
    this.apiService
      .saveForm(this.formBuilderObject.value)
      .subscribe((res) => {
        console.log(res)
      });
  }
}
