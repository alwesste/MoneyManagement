import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginFormComponent} from "./login-form/login-form.component";
import {SubscribeFormComponent} from "./subscribe-form/subscribe-form.component";
import {AccountComponent} from "./account/account.component";
import {GroupComponent} from "./group/group.component";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'subscribe', component: SubscribeFormComponent},
  {path: 'account/:username', component: AccountComponent},
  {path:'group', component: GroupComponent},
];
