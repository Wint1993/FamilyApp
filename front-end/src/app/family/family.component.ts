import {Component, OnInit, ViewChild} from '@angular/core';
import {DataService} from "../shared/service/DataService";
import {Father} from "../shared/models/father.model";
import {Child} from "../shared/models/child.model";
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Router} from "@angular/router";
import {Family} from "../shared/models/family.model";

@Component({
  selector: 'app-family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css']
})
export class FamilyComponent implements OnInit {

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  public displayedColumns = ['name', 'lastName', 'pesel', 'birthDate' , 'sex'];
  public dataSource;

  father: Father;
  childTable: Child [] = [];
  family: Family [] = [];

  constructor(private data: DataService,
              private router: Router) {
  }

  ngOnInit() {
    this.init();
  }

  public init(){
    this.father = null;
    this.data.currentMessage2.subscribe(message =>
    {
      this.father = message;
      if(this.father == null){
        this.router.navigate(['']);
      }
    });
    this.childTable = null;
    this.data.currentMessage1.subscribe(message1 =>
    {
      this.childTable = message1;
    });
      this.getFamily();
  }

  public getFamily(){
    this.dataSource = new MatTableDataSource<Child>(this.childTable);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }



}
