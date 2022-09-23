import {todoStore} from "../stores/GiraffeStore";
import {Button, Grid, TextField} from "@mui/material";
import {useState} from "react";
import {observer} from "mobx-react-lite";

export const GiraffePage = observer(() =>{
  const [text,setText] = useState("");
  return (
    <Grid container >
      <Grid xs={12}>
        {todoStore.Giraffes.map((giraffe, index)=>
            <div key={index}>
              <h3>{giraffe}</h3>
            </div>
        )}
        <div>New Giraffe</div>
        <div>
          <TextField value={text} onChange={(e)=>setText(e.target.value)}/>
        </div>
      </Grid>
      <Grid xs={6} sm={4} md={2}>
          <Button variant={"contained"} onClick={()=>{
            todoStore.addTodo(text);
            setText("");
          }}>Add Giraffe</Button>
      </Grid>
      <Grid xs={6}>
        <Button variant={"contained"}>Remove Giraffe</Button>
      </Grid>
    </Grid>)
})