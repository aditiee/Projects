import { Feedback } from './feedback';
import { UserInfo } from './user-info';
export class Feedbackresponse {


    constructor(
        
        public  userinfo:Array<UserInfo>,
        public  feedbacks:Array<Feedback>
       
    ) { }
}

