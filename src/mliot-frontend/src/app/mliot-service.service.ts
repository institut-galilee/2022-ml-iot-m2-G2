import {Injectable} from '@angular/core';
import {environment} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MliotServiceService {

  getQuestionsList() {
    return fetch(environment.apiURL + 'questions')
  }
}
