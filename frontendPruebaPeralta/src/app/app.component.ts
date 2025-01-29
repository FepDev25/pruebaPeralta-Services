import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BinomiosComponent } from './components/binomios/binomios.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BinomiosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontendPruebaPeralta';
}
