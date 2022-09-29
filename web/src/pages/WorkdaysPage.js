import {todoStore} from "../stores/GiraffeStore";
import {Button, Grid, Stack, TextField} from "@mui/material";
import {useState} from "react";
import {observer} from "mobx-react-lite";




export const WorkdaysPage = observer(() => {
        const [startDate,setStartdate] = useState(new Date().toISOString().split("T")[0]);
        console.log(new Date(startDate))
        const handleDatePick = ({target}) => {
            setStartdate(target.value)
        };
        return (<div>
            <Stack component={"form"}>
                <TextField type={"date"} sx={{width: 220}} onChange={handleDatePick} value={startDate}/>
                <TextField type={"date"} sx={{width: 220}} value={startDate}/>
            </Stack>
        </div>)
    }
)