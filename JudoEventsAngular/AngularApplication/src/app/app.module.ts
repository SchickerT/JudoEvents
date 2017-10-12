import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './app-components/navbar/navbar.component';
import {MainpageComponent} from "./app-components/mainpage/mainpage.component";
import { FooterComponent } from './app-components/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainpageComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
