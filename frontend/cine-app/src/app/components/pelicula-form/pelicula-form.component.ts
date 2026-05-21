import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GeneroService } from '../../services/genero.service';
import { PeliculaService } from '../../services/pelicula.service';
import { Genero } from '../../models/genero.model';

@Component({
  selector: 'app-pelicula-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './pelicula-form.component.html'
})
export class PeliculaFormComponent implements OnInit {
  form: FormGroup;
  generos = signal<Genero[]>([]);

  constructor(
    private fb: FormBuilder,
    private generoService: GeneroService,
    private peliculaService: PeliculaService,
    private router: Router
  ) {
    this.form = this.fb.group({
      titulo: ['', Validators.required],
      anio: ['', [Validators.required, Validators.min(1900)]],
      director: ['', Validators.required],
      sinopsis: ['', Validators.required],
      generoId: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.generoService.getAll().subscribe((data: Genero[]) => this.generos.set(data));
  }

  onSubmit(): void {
    if (this.form.valid) {
      const { generoId, ...rest } = this.form.value;
      const genero = this.generos().find((g: Genero) => g.id === Number(generoId));
      if (!genero) return;
      this.peliculaService.create({ ...rest, genero }).subscribe(() => {
        this.router.navigate(['/generos']);
      });
    }
  }
}
