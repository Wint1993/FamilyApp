export class Child {

  id: number;
  name: string;
  lastName: string;
  pesel: string;
  sex: string;
  birthDate: Date;

  constructor(id: number, name: string, lastName: string, sex: string, pesel: string, birthDate: Date) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.pesel = pesel;
    this.sex = sex;
    this.birthDate = birthDate;
  }

}

