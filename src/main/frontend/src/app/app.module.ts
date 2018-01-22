import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatSnackBarModule} from "@angular/material";
import {HttpModule} from "@angular/http";
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { AsideComponent } from './components/aside/aside.component';
import { MainDashboardComponent } from './components/main-dashboard/main-dashboard.component';
import {RouterModule} from "@angular/router";
import {routes} from "./app.routes";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AsideComponent,
    MainDashboardComponent
  ],
  imports: [
    /* Angular Module */
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(routes),
    /* Angular Animation & Material Module */
    BrowserAnimationsModule,
    MatSnackBarModule,MatCardModule,MatButtonModule,
    /* App Module */
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
