import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import "@angular/compiler";
import { TutorStudentsRequestComponent } from './tutor-students-request/tutor-students-request.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { DataTablesModule } from 'angular-datatables';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatPaginatorModule} from '@angular/material/paginator';

import {NgxPaginationModule} from 'ngx-pagination';
import { TutorTrainingsComponent } from './tutor-trainings/tutor-trainings.component';
import { TrainingContentsComponent } from './training-contents/training-contents.component';
import { TutorStudentsComponent } from './tutor-students/tutor-students.component';
import { UploadcontentComponent } from './uploadcontent/uploadcontent.component';
import { AddTrainingComponent } from './add-training/add-training.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { StudentTutorListComponent } from './student-tutor-list/student-tutor-list.component';
import { StudentTrainingRequestComponent } from './student-training-request/student-training-request.component';
import { StudentWaitingRequestComponent } from './student-waiting-request/student-waiting-request.component';
import { StudentApprovedRequestComponent } from './student-approved-request/student-approved-request.component';
import { StudentTrainingContentComponent } from './student-training-content/student-training-content.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactComponent } from './contact/contact.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegisterComponent } from './register/register.component';
import { CarouselModule } from 'ngx-owl-carousel-o';
import { AdminTutorRequestListComponent } from './admin-tutor-request-list/admin-tutor-request-list.component';
import { AdminStudentRequestListComponent } from './admin-student-request-list/admin-student-request-list.component'; 
import {MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table'; 
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatSliderModule} from '@angular/material/slider';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AdminTutorListComponent } from './admin-tutor-list/admin-tutor-list.component';
import { AdminStudentListComponent } from './admin-student-list/admin-student-list.component';
import { AdminTutorStudentListComponent } from './admin-tutor-student-list/admin-tutor-student-list.component';
import { AdminTutorTrainingListComponent } from './admin-tutor-training-list/admin-tutor-training-list.component';
import { UploadStatusComponent } from './upload-status/upload-status.component';
import { DownloadStatusComponent } from './download-status/download-status.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AdminDownloadStatusComponent } from './admin-download-status/admin-download-status.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { TutorFeedbackComponent } from './tutor-feedback/tutor-feedback.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TutorStudentsRequestComponent,
    HeaderComponent,
    HomeComponent,
    SidebarComponent,
    TutorTrainingsComponent,
    TrainingContentsComponent,
    TutorStudentsComponent,
    UploadcontentComponent,
    AddTrainingComponent,
    AddSubjectComponent,
    StudentTutorListComponent,
    StudentTrainingRequestComponent,
    StudentWaitingRequestComponent,
    StudentApprovedRequestComponent,
    StudentTrainingContentComponent,
    AboutusComponent,
    ContactComponent,
    PageNotFoundComponent,
    RegisterComponent,
    AdminTutorRequestListComponent,
    AdminStudentRequestListComponent,
    AdminTutorListComponent,
    AdminStudentListComponent,
    AdminTutorStudentListComponent,
    AdminTutorTrainingListComponent,
    UploadStatusComponent,
    DownloadStatusComponent,
    AdminDownloadStatusComponent,
    FeedbackComponent,
    TutorFeedbackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    MatListModule,
    DataTablesModule,
    NgbModule,
    MatPaginatorModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    CarouselModule,
    BrowserAnimationsModule,
    MatSortModule,
    MatTableModule,
    MatInputModule,
    MatCardModule,
    MatSliderModule,FlexLayoutModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
