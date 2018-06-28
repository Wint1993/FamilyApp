import {Father} from "./father.model";
import {Child} from "./child.model";

export class Family {

  fatherDto: Father;
  childDtos: Child [] = [];

  constructor( father: Father, child: Child[]) {
    this.fatherDto = father;
    this.childDtos = child;
  }
}

