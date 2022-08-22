import {Button} from "@mui/material";
import {userStore} from "../stores/UserStore";

export const LoginPage = ()=>(
    <div>
        <Button onClick={userStore.login}>
            Login
        </Button>
        </div>
)