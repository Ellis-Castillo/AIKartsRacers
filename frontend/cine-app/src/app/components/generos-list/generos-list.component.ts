import { Component, OnInit, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { GeneroService } from '../../services/genero.service';
import { Genero } from '../../models/genero.model';

@Component({
  selector: 'app-generos-list',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './generos-list.component.html'
})
export class GenerosListComponent implements OnInit {
  generos = signal<Genero[]>([]);

  constructor(private generoService: GeneroService) {}

  ngOnInit() {
    this.generoService.getAll().subscribe(data => {
      this.generos.set(data);
    });
  }
}