import {giraffeStore} from "../stores/GiraffeStore";
import {Button, Grid, TextField} from "@mui/material";
import {useState} from "react";
import {observer} from "mobx-react-lite";

export const GiraffePage = observer(() =>{
  const [text,setText] = useState("");
  return (
    <Grid container >
      <Grid xs={12}>
        {giraffeStore.Giraffes.map((giraffe, index)=>
            <div key={index}>
              <h3>{giraffe}</h3>
            </div>
        )}
        <div>Add new Giraffe</div>
        <div>
          <TextField value={text} onChange={(e)=>setText(e.target.value)}/>
        </div>
      </Grid>
      <Grid xs={6} sm={4} md={2}>
          <Button variant={"contained"} onClick={()=>{
            giraffeStore.addTodo(text);
            setText("");
          }}>Add Giraffe</Button>
      </Grid>
      <Grid xs={6}>
        <Button variant={"contained"} onClick={()=>giraffeStore.removeGiraffe()}>Remove Giraffe</Button>
      </Grid>
    </Grid>)
})