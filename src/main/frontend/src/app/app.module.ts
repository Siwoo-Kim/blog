import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatRadioModule, MatToolbarModule, MatSnackBarModule} from "@angular/material";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    /* Angular Module */
    BrowserModule,HttpModule,FormsModule,

    /* Animation and Material Module */
    BrowserAnimationsModule,
    MatToolbarModule, MatSnackBarModule, MatCardModule,
    MatInputModule, MatRadioModule, MatButtonModule,
    /* App Module */,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
