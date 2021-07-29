import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[], args: string): any[] {
    if(!value) return [];
    if(!args) return value;

  return [...value.filter(t =>{return t.technologyName.toLowerCase().includes(args.toLowerCase())}),
   ...value.filter(t =>{return t.userName.toLowerCase().includes(args.toLowerCase())})];

  }


}
