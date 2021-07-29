export class Feedback {

    constructor(
        public feedbackId:number,
        public studentId:number,
        public tutorId:number,
        public remarks: string,
        public rating:number,
        public  created_on: Date
    ) { }
}
