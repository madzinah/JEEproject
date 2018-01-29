import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Item } from './item';
import {Observable} from "rxjs/Observable";


@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.css']
})
@Injectable
export class MediaComponent implements OnInit {

  constructor(private http : HttpClient) { }
  private baseUrl = 'http://localhost:8080';

  items : Observable<Item[]>;

  ngOnInit() {
    this.items = this.http.get<Item[]>(this.baseUrl + '/api/items');
  }

}
