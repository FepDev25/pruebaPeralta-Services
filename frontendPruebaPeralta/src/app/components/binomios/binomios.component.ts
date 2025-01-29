import { Component, inject } from '@angular/core';
import { BinomiosService } from '../../services/binomios.service';
import { Binomio } from '../../models/binomio.model';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-binomios',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './binomios.component.html',
  styleUrl: './binomios.component.scss'
})
export class BinomiosComponent {

  binomio : Binomio = new Binomio();
  mensajeUsuario : string = '';

  binomios$ : Observable<Binomio[]>;
  binomios : Binomio[] = [];

  private _binomioService = inject(BinomiosService);

  constructor(){
    this.binomios$ = this._binomioService.getBinomios();

    this.binomios$.subscribe(binomios => {
      this.binomios = binomios;
    });
  }

  guardarBinomio(form: NgForm){
    if (form.valid) {
      this._binomioService.createBinomio(this.binomio).subscribe({
        next: (nuevoBinomio) => {
          this.mensajeUsuario = 'Usuario registrado exitosamente.';
  
          this.binomios.push(nuevoBinomio);
  
          form.resetForm();
        },
        error: (err) => {
          console.error('Error al registrar usuario:', err);
          this.mensajeUsuario = 'Ocurrió un error al registrar el binomio.';
        }
      });
    } else {
      this.mensajeUsuario = 'Por favor, completa todos los campos correctamente.';
    }
  }
}
