import { TutorFeedbackComponent } from './tutor-feedback/tutor-feedback.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { AdminDownloadStatusComponent } from './admin-download-status/admin-download-status.component';
import { DownloadStatusComponent } from './download-status/download-status.component';
import { UploadStatusComponent } from './upload-status/upload-status.component';
import { AdminTutorTrainingListComponent } from './admin-tutor-training-list/admin-tutor-training-list.component';
import { AdminTutorStudentListComponent } from './admin-tutor-student-list/admin-tutor-student-list.component';
import { AdminStudentListComponent } from './admin-student-list/admin-student-list.component';
import { AdminTutorListComponent } from './admin-tutor-list/admin-tutor-list.component';
import { AdminTutorRequestListComponent } from './admin-tutor-request-list/admin-tutor-request-list.component';
import { AdminStudentRequestListComponent } from './admin-student-request-list/admin-student-request-list.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ContactComponent } from './contact/contact.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { StudentTrainingContentComponent } from './student-training-content/student-training-content.component';
import { StudentApprovedRequestComponent } from './student-approved-request/student-approved-request.component';
import { StudentWaitingRequestComponent } from './student-waiting-request/student-waiting-request.component';
import { StudentTrainingRequestComponent } from './student-training-request/student-training-request.component';
import { StudentTutorListComponent } from './student-tutor-list/student-tutor-list.component';
import { AddSubjectComponent } from './add-subject/add-subject.component';
import { AddTrainingComponent } from './add-training/add-training.component';
import { UploadcontentComponent } from './uploadcontent/uploadcontent.component';
import { TutorStudentsComponent } from './tutor-students/tutor-students.component';
import { TrainingContentsComponent } from './training-contents/training-contents.component';
import { TutorTrainingsComponent } from './tutor-trainings/tutor-trainings.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { TutorStudentsRequestComponent } from './tutor-students-request/tutor-students-request.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  { path: '', component: HomeComponent },
  {path: 'aboutus', component:AboutusComponent},
{path:'login',component:LoginComponent},
{path:'register',component:RegisterComponent},
{path:'contact',component:ContactComponent},
{path:'sidebar',component:SidebarComponent,
 children: [
      {
        path: 'tutor-students-request', component:TutorStudentsRequestComponent

      },
      {
        path: 'tutor-trainings',  component: TutorTrainingsComponent
      },
      {
        path:'training-contents/:id', component:TrainingContentsComponent,
        
      },
      {
        path:'uploadcontent/:id', component:UploadcontentComponent
          },
      {
        path:'tutor-students', component:TutorStudentsComponent
      },
      {
        path:'add-training', component:AddTrainingComponent
      },
      {
        path:'add-subject', component:AddSubjectComponent
      },
      {
        path:'student-tutor-list',component:StudentTutorListComponent
      },
      {
        path:'student-training-request',component:StudentTrainingRequestComponent
      },
      {
        path:'student-waiting-request',component:StudentWaitingRequestComponent
      },
      {
        path:'student-approved-request',component:StudentApprovedRequestComponent
      },
      {
        path:'student-training-contents/:id',component:StudentTrainingContentComponent
      },
      {
        path:'admin-student-request-list',component:AdminStudentRequestListComponent
      },
      {
        path:'admin-tutor-request-list',component:AdminTutorRequestListComponent
      },
      {
        path:'admin-tutor-list',component:AdminTutorListComponent
      },
      {
        path:'admin-student-list',component:AdminStudentListComponent
      },
      {
        path:'admin-tutor-student-list/:id',component:AdminTutorStudentListComponent
      },
      {
        path:'admin-tutor-training-list/:id',component:AdminTutorTrainingListComponent
      },
      {
        path:'upload-status', component:UploadStatusComponent
      },
      {
        path:'download-status', component:DownloadStatusComponent
      },
      {
        path:'admin-download-status', component:AdminDownloadStatusComponent
      },
      { 
        path:'sendFeedback' , component: FeedbackComponent 
      },
      { 
        path:'tutor-feedback' , component: TutorFeedbackComponent
      }
 ]

} ,
{ path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
