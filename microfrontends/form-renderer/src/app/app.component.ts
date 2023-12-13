import {
  Component,
  Input,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { MfeConfigModel } from './shared/models/mfe-config.model';
import { ApiService } from './shared/services/api.service';
import { FormioForm } from '@formio/angular';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnChanges {
  @Input() config!: string;

  public form$: Observable<FormioForm> = this.apiService.getForm(); 

  private configParsed: MfeConfigModel;

  constructor(private apiService: ApiService) {
    fetch('https://examples.form.io/example')
      .then((res) => res.json())
      .then((res) => console.log(res));
  }

  public ngOnChanges(changes: SimpleChanges) {
    if (changes['config']) {
      this.configParsed = JSON.parse(this.config);
      this.apiService.config = this.configParsed;
    }
  }

  public onSubmit(event) {
    console.log(event)
  }
}
