import {makeAutoObservable} from "mobx";

class UserStore {
    user = null;
    constructor(){
        makeAutoObservable(this,{},{autoBind:true})
        //TODO: Load user from localStorage
    }

    login(){
        //TODO: Real Login
        this.user = {}
    }

}

export const userStore = new UserStore();