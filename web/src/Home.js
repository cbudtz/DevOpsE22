import {Link, useNavigate} from "react-router-dom";
import {Button} from "@mui/material";

export function Home({onClick, userName}) {
    let navigate = useNavigate();
    return <div className="App">
        <div>Hello, {userName}</div>
        <Button onClick={onClick}>Skift navn</Button>
        <div>
            <Link to={"about/link"}>Go to greeting</Link>
        </div>
        <Button onClick={(e) => navigate("about/button")}>Or like this</Button>
        <div>
            <Link to={"giraffes"}>Look at giraffes!</Link>
        </div>
    </div>;
}