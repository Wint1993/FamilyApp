import {BehaviorSubject} from "rxjs/index";
import {Injectable} from "@angular/core";
import {Father} from "../models/father.model";
import {Child} from "../models/child.model";

@Injectable()
export class DataService {

  private father: Father;
  private father1: Father;
  private childTableBack: Child [] = [];

  private messageSource = new BehaviorSubject(this.father);
  currentMessage = this.messageSource.asObservable();

  private messageSource2 = new BehaviorSubject(this.father1);
  currentMessage2 = this.messageSource2.asObservable();

  private messageSource1 = new BehaviorSubject(this.childTableBack);
  currentMessage1 = this.messageSource1.asObservable();

  constructor() { }

  changeMessage(father: Father) {
    this.messageSource.next(father)
  }

  changeMessage2(father: Father) {
    this.messageSource2.next(father)
  }

  changeMessage1(childTableBack:  Child [] ) {
    this.messageSource1.next(childTableBack)
  }
}
