import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeleteStudentComponent } from './admin/components/delete-student/delete-student.component';
import { DeleteTutorComponent } from './admin/components/delete-tutor/delete-tutor.component';

import { NavbarComponent } from './admin/components/navbar/navbar.component';
import { PendingStudentListComponent } from './admin/components/pending-student-list/pending-student-list.component';
import { PendingTutorListComponent } from './admin/components/pending-tutor-list/pending-tutor-list.component';

import { LoginComponent } from './home/components/login/login.component';
import { PageNotFoundComponent } from './home/components/page-not-found/page-not-found.component';
import { MaterialComponent } from './student/components/material/material.component';
import { SearchComponent } from './student/components/search/search.component';
import { StudentnavbarComponent } from './student/components/studentnavbar/studentnavbar.component';
import { TutorlistComponent } from './student/components/tutorlist/tutorlist.component';
import { TutornavbarComponent } from './tutor/components/tutornavbar/tutornavbar.component';
import { AuthGuard } from './utilities/auth.guard';




const routes: Routes = [
  // {
  //   path: 'admin',
  //   loadChildren: () =>
  //     import('./admin/admin.module').then((m) => m.AdminModule)
  // },
  // {
  //   path: 'tutor',
  //   loadChildren: () =>
  //     import('./tutor/tutor.module').then(
  //       (m) => m.TutorModule
  //     )
  // },
  // {
  //   path:'tutor',loadChildren:()=>import('./tutor/tutor.module').then((m)=>m.TutorModule)
  // },
  // {
  //   path: 'student',
  //   loadChildren: () =>
  //     import('./student/student.module').then(
  //       (m) => m.StudentModule
  //     )
  // },
  {path:'login',component:LoginComponent},
  {path:'admin/navbar',component:NavbarComponent, canActivate:[AuthGuard]},
  {path:'tutor/navbar',component:TutornavbarComponent, canActivate:[AuthGuard]},
  {path:'student/navbar',component:StudentnavbarComponent, canActivate:[AuthGuard]},
  {path:'admin/pendingtutor',component:PendingTutorListComponent, canActivate:[AuthGuard]},
  {path:'admin/pendingstudent',component:PendingStudentListComponent, canActivate:[AuthGuard]},
  {path:'admin/deletetutor',component:DeleteTutorComponent, canActivate:[AuthGuard]},
  {path:'admin/deletestudent',component:DeleteStudentComponent, canActivate:[AuthGuard]},
  {path:'student/search',component:SearchComponent},
  {path:'student/viewcourses', component: TutorlistComponent, canActivate:[AuthGuard]},
  {path:'student/mycourses', component: MaterialComponent },
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
