import {Component, OnInit} from '@angular/core';
import {Father} from "../shared/models/father.model";
import {DataService} from "../shared/service/DataService";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Child} from "../shared/models/child.model";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable, Subject} from "rxjs/index";


@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  father: Father;
  child: Child;
  form: FormGroup;
  childTable: Child [] = [];
  selectedValue: string;
  panelOpenState = false;
  familyId: string;

  fatherBack: Father = null;
  childTableBack: Child [] = [];

  sex: Sex[] = [
    {value: 'man', viewValue: 'Man'},
    {value: 'woman', viewValue: 'Woman'}
  ];

  private formSubmitAttempt: boolean;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private data: DataService,
              private http: HttpClient) {
    this.father = null;
   }

  ngOnInit() {
    this.father = null;
    this.data.currentMessage.subscribe(message =>
        {
          this.father = message;
          if(this.father == null){
            this.router.navigate(['']);
          }});

      this.form = this.formBuilder.group({
      name: [null, Validators.required],
      lastName: [null, Validators.required],
      pesel: [null, Validators.required],
      date: [null, Validators.required],
      selectedValue:['', Validators.required]
    })
  }

  saveResult(): void{
    this.formSubmitAttempt = true;
    if(this.form.valid){
      this.child = new Child(null,this.form.get('name').value,this.form.get('lastName').value,this.form.get('selectedValue').value,this.form.get('pesel').value,this.form.get('date').value);
      this.childTable.push(Object.assign(this.child));
    } else {
      this.validateAllFormFields(this.form);
    }
    this.form.reset();
  }

  create(): Observable<HttpResponse<any>>{
    const observable = new Subject<HttpResponse<any>>();
    this.createFamily();
    return observable;
  }

  createFamily():void{
    this.http.put<any>('/rest/family/create',{ })
      .subscribe(res =>
      {
        this.familyId = res;
        this.createFather();
      },err => {
      });
  }

   createFather():any{
     let date = this.father.birthDate;
     if (!(typeof date === 'string')) {
       date.setHours(date.getHours() - (date.getTimezoneOffset() / 60));
     }
     this.father.birthDate = date;
     this.http.put<any>('/rest/father/create?familyId='+Object.values(this.familyId),this.father)
      .subscribe(res =>
      {
        this.fatherBack = res;
        this.sendFather();
        this.createChildren()
      },err => {
      });
  }

  createChildren():any{
    this.http.put<any>('/rest/child/create?familyId='+Object.values(this.familyId),this.childTable)
      .subscribe(res =>
      {
        this.childTableBack = res;

        this.sendChilds();
        this.router.navigate(['family']);

      },err => {
      });

  }

  sendFather() {
    this.data.changeMessage2(this.fatherBack);
  }
  sendChilds() {
    this.data.changeMessage1(this.childTableBack);
  }
  delete(i): void{
    this.childTable.splice(i,1);
  }

  isFieldValid(field: string) {
    return (!this.form.get(field).valid && this.form.get(field).touched);
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({onlySelf: true});
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
}

export interface Sex {
  value: string;
  viewValue: string;
}

