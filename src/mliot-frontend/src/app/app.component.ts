import {Component, HostListener, OnInit} from '@angular/core';
import {MliotServiceService} from './mliot-service.service';
import arrayShuffle from "array-shuffle";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'FrontMLIOT';
  questions!: {
    question_text: string;
    question_marks: string;
    question_responses: string[];
  };
  reference!: string
  p: number = 1;
  questionnaire! : any[]
  height: number = 200

  constructor(private mliotService : MliotServiceService){}

  public ngOnInit(): void {
    this.mliotService.getQuestionsList()
      .then(response => response.json())
      .then(exam => {
        console.log(exam)
        this.reference = exam.exam_reference
        this.questionnaire = arrayShuffle(exam.exam_questions)
      })
      .catch(error => console.log(error))
  }

  @HostListener('window:resize', ['$event'])
  public onResize(event: any) {
    this.height = event.target.innerHeight * 0.2
  }
}
