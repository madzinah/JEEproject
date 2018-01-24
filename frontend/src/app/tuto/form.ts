import { Injectable } from '@angular/core';
import { Component } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'form-hello',
  templateUrl: './form.html'
})
@Injectable()
export class AppForm {
  message = "";
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { console.error("test"); }

  hello(name) {
    console.error(name);
    this.http.get(this.baseUrl + '/api/hello/' + "bob")
      .toPromise().then(response => this.message = response.toString())
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }

}
