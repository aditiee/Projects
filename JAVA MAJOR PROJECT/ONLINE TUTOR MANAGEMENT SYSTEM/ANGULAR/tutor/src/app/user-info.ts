export class UserInfo {
        constructor(
        public userId:number,
        public firstName: string,
        public middleName: string,
        public lastName: string,
        public mobile: string,
        public email: string,
        public password: string,
        public createdBy: number,
        public createdOn: Date,
        public lastModifiedBy: number,
        public lastModifiedOn:Date,
        public active:boolean
    ) { }
}
