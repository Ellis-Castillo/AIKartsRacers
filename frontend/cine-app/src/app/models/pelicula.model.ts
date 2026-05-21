import { Genero } from './genero.model';

export interface Pelicula {
  id?: number;
  titulo: string;
  anio: number;
  director: string;
  sinopsis: string;
  genero: Genero;
}