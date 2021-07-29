import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './home/components/login/login.component';
import { PageNotFoundComponent } from './home/components/page-not-found/page-not-found.component';
import { BasicAuthHttpInterceptorService } from './home/services/basic-auth-http-interceptor.service';
import { SharedModule } from './shared/shared.module';
import { NavbarComponent } from './admin/components/navbar/navbar.component';
import { PendingTutorListComponent } from './admin/components/pending-tutor-list/pending-tutor-list.component';
import { StudentnavbarComponent } from './student/components/studentnavbar/studentnavbar.component';
import { TutornavbarComponent } from './tutor/components/tutornavbar/tutornavbar.component';
import { AdminService } from './admin/services/admin.service';
import { PendingStudentListComponent } from './admin/components/pending-student-list/pending-student-list.component';
import { SearchComponent } from './student/components/search/search.component';
import { DeleteTutorComponent } from './admin/components/delete-tutor/delete-tutor.component';
import { DeleteStudentComponent } from './admin/components/delete-student/delete-student.component';
import { TutorlistComponent } from './student/components/tutorlist/tutorlist.component';
import { MaterialComponent } from './student/components/material/material.component';
import { FilterPipe } from './utilities/filter.pipe';
import { AuthGuard } from './utilities/auth.guard';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    NavbarComponent,
    PendingTutorListComponent,
    StudentnavbarComponent,
    TutornavbarComponent,
    PendingStudentListComponent,
    SearchComponent,
    DeleteTutorComponent,
    DeleteStudentComponent,
    TutorlistComponent,
    MaterialComponent,
    FilterPipe
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    RouterModule
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  providers: [AdminService,{ provide:HTTP_INTERCEPTORS, useClass: BasicAuthHttpInterceptorService, multi: true },AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
