import {todoStore} from "../stores/GiraffeStore";
import {Button, TextField} from "@mui/material";
import {useState} from "react";
import {observer} from "mobx-react-lite";

export const GiraffePage = observer(props =>{
  const [text,setText] = useState("");
  return (<div>
    {todoStore.Giraffes.map((giraffe, index)=>
        <div key={index}>
          <h3>{giraffe}</h3>
        </div>
    )}
    <div>Ny todo</div>
    <div>
      <TextField value={text} onChange={(e)=>setText(e.target.value)}/>
    </div>
    <Button onClick={()=>{
      todoStore.addTodo(text);
      setText("");
    }}>Add Giraffe</Button>
  </div>)
})