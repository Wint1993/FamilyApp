import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FatherComponent } from './father/father.component';
import { ChildComponent } from './child/child.component';
import { FamilyComponent } from './family/family.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {
  MatButtonModule, MatDatepickerModule, MatExpansionModule, MatInputModule, MatListModule, MatNativeDateModule,
  MatPaginatorModule,
  MatSelectModule, MatSortModule, MatTableModule
} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { FieldErrorDisplayComponent } from './field-error-display/field-error-display.component';
import {DataService} from "./shared/service/DataService";
import {HttpClientModule} from "@angular/common/http";
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    FatherComponent,
    ChildComponent,
    FamilyComponent,
    FieldErrorDisplayComponent,
    HeaderComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatListModule,
    MatExpansionModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule

  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
