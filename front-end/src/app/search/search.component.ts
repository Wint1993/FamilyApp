import {Component, OnInit, ViewChild} from '@angular/core';
import {Family} from "../shared/models/family.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Father} from "../shared/models/father.model";
import {Child} from "../shared/models/child.model";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {DataService} from "../shared/service/DataService";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  public displayedColumns = ['name', 'lastName','pesel', 'birthDate', 'actions'];
  public dataSource1;

  father: Father;
  fatherTab: Father [] = [];
  family: Family [] = [];
  childTable: Child [] = [];
  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private http: HttpClient,
              private data: DataService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: [null,null]
    })
  }

  findFamily(){
    this.family = [];
    this.http.get<Family[]>('/rest/family/'+this.form.get('name').value,{ })
      .subscribe((data: Family[]) =>
      {
        for (let i = 0; i < data.length; i++) {
          this.family.push(Object.assign(new Family(null, null), data[i]))
        }
        for (let k = 0; k < this.family.length; k++) {
          this.fatherTab.push(this.family[k].fatherDto);
        }
        this.dataSource1 = new MatTableDataSource<Father>(this.fatherTab);
        this.dataSource1.paginator = this.paginator;
        this.dataSource1.sort = this.sort;
      },err => {
      });

  }

  detail(element): void{
    console.log(element);
    for (let k = 0; k < this.family.length; k++) {
      if(this.family[k].fatherDto.id == element.id){
        this.childTable = this.family[k].childDtos;
      }
    }
    this.sendFather(element);
    this.sendChilds();
    this.router.navigate(['family']);

  }

  sendChilds() {
    this.data.changeMessage1(this.childTable);
  }
  sendFather(element) {
    this.data.changeMessage2(element);
  }



}
