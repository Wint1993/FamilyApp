import {RouterModule, Routes} from "@angular/router";
import {FatherComponent} from "./father/father.component";
import {NgModule} from "@angular/core";
import {ChildComponent} from "./child/child.component";
import {FamilyComponent} from "./family/family.component";
import {SearchComponent} from "./search/search.component";

const routes: Routes = [
  {path: '', component: FatherComponent
  },
  {path: 'home', component: FatherComponent
  },
  {path: 'child', component: ChildComponent
  },
  {path: 'family', component: FamilyComponent
  },
  {path: 'search', component: SearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
})
export class AppRoutingModule {

}
