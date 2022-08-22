import {makeAutoObservable} from "mobx";

class TodoStore {
    Todos = ["Skrive til henrik","Fiske"];
    constructor() {
        makeAutoObservable(this,
            {},
            {autoBind:true}//For non-arrow-functions bind
        )
    }
    addTodo = (todo)=> {
        this.Todos.push(todo);
    }

}

export const todoStore = new TodoStore();