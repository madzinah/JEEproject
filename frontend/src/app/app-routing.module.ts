import { NgModule } from '@angular/core';
import { MediaComponent }      from './media/media/media.component';
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  { path: 'media', component: MediaComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
