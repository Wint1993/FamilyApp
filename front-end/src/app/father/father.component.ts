import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Father} from "../shared/models/father.model";
import {Router} from "@angular/router";
import {DataService} from "../shared/service/DataService";

@Component({
  selector: 'app-father',
  templateUrl: './father.component.html',
  styleUrls: ['./father.component.css']
})
export class FatherComponent implements OnInit {

  form: FormGroup;
  private formSubmitAttempt: boolean;
  public father: Father;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private data: DataService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: [null, Validators.required],
      lastName: [null, Validators.required],
      pesel: [null, Validators.required],
      date: [null, Validators.required]
    })
  }

  saveResult(): void{
    this.formSubmitAttempt = true;
    if(this.form.valid){
       this.father = new Father(null,this.form.get('name').value,this.form.get('lastName').value,this.form.get('pesel').value,this.form.get('date').value);
       this.sendFather();
       this.router.navigate(['child']);
    } else {
      this.validateAllFormFields(this.form);
    }
  }

  sendFather() {
    this.data.changeMessage(this.father);
  }

  isFieldValid(field: string) {
    return (!this.form.get(field).valid && this.form.get(field).touched) ||
      (this.form.get(field).untouched && this.formSubmitAttempt);
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
