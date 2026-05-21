import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { GeneroService } from '../../services/genero.service';
import { PeliculaService } from '../../services/pelicula.service';
import { Genero } from '../../models/genero.model';
import { Pelicula } from '../../models/pelicula.model';

@Component({
  selector: 'app-genero-detail',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './genero-detail.component.html'
})
export class GeneroDetailComponent implements OnInit {
  genero = signal<Genero | null>(null);
  peliculas = signal<Pelicula[]>([]);

  constructor(
    private route: ActivatedRoute,
    private generoService: GeneroService,
    private peliculaService: PeliculaService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.generoService.getById(id).subscribe(data => this.genero.set(data));
    this.peliculaService.getByGenero(id).subscribe(data => this.peliculas.set(data));
  }
}