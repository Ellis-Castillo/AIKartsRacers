import { Routes } from '@angular/router';
import { GenerosListComponent } from './components/generos-list/generos-list.component';
import { GeneroDetailComponent } from './components/genero-detail/genero-detail.component';
import { PeliculaFormComponent } from './components/pelicula-form/pelicula-form.component';
 
export const routes: Routes = [
  { path: '', redirectTo: 'generos', pathMatch: 'full' },
  { path: 'generos', component: GenerosListComponent },
  { path: 'generos/:id', component: GeneroDetailComponent },
  { path: 'peliculas/nueva', component: PeliculaFormComponent }
];
