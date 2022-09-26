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

    get numberOfGiraffes(){
        return this.Giraffes.length
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
    removeGiraffe = ()=>{
        this.Giraffes.pop();
    }

}

export const giraffeStore = new GiraffeStore();