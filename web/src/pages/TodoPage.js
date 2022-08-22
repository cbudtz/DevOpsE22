import {todoStore} from "../stores/TodoStore";
import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {observer} from "mobx-react-lite";

export const TodoPage = observer(props =>{
  const [text,setText] = useState("");
  return (<div>
    {todoStore.Todos.map((todo,index)=>
        <div key={index}>
          <h3>{todo}</h3>
        </div>
    )}
    <div>Ny todo</div>
    <div>
      <TextField value={text} onChange={(e)=>setText(e.target.value)}/>
    </div>
    <Button onClick={()=>{
      todoStore.addTodo(text);
      setText("");
    }}>Tilføj Todo</Button>
  </div>)
})