import {makeAutoObservable, runInAction} from "mobx";

const baseUrl = process.env.NODE_ENV === 'development' ?
    "http://localhost:8080/":
    ""; //Check if dev environment

class GiraffeStore {
    Giraffes = ["loading"];
    constructor() {
        makeAutoObservable(this,
            {},
            {autoBind:true}//For non-arrow-functions bind
        )
        this.fetchGiraffes();
    }
    fetchGiraffes() {
        fetch(baseUrl + "api/giraffes").then(
            (response)=> response.json().then(
                (json)=> runInAction(()=>this.Giraffes=json)
            )
        )

    }
    addTodo = (giraffe)=> {
        this.Giraffes.push(giraffe);
    }

}

export const todoStore = new GiraffeStore();