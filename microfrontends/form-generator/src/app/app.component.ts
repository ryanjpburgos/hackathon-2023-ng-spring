import { HttpClient } from '@angular/common/http';
import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnChanges {
  @Input() config!: any;
  configParsed: any;
  name: any;
  title = 'form-generator';
  simpleText!: string;

  constructor(private http: HttpClient) {}

  ngOnChanges(changes: SimpleChanges) {
    if (changes['config']) {
      console.log("config changes ", this.config)
      this.configParsed = JSON.parse(this.config);
      this.name = (this.configParsed && this.configParsed.params) ? this.configParsed.params.name : "";
      console.log("params ", this.name)
    }
  }


  public makeCall() {
    this.http.get<{payload: string}>(`${this.configParsed['systemParams'].api['spring-api'].url}/api/example`).subscribe((res) => {
      this.simpleText = res.payload;
    })
  }
}
