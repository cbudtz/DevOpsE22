import './App.css';
import {useState} from "react";
import {Route, Routes} from "react-router-dom"
import {Home} from "./Home";
import {Greeting} from "./Greeting";
import {GiraffePage} from "./pages/GiraffePage";
import {userStore} from "./stores/UserStore";
import {LoginPage} from "./pages/LoginPage";
import {observer} from "mobx-react-lite";
import {WorkdaysPage} from "./pages/WorkdaysPage";
import {ExperimentPage} from "./pages/ExperimentPage";


function App() {
    const [username, setUsername] = useState("Brian")
    if (!userStore.user){
        return (<LoginPage/>)
    }
    return (
        <Routes>
            <Route path="/" element ={
                <Home userName={username} onClick={(e) => setUsername("Johnny")}/>}/>
            <Route path={"/about/:value"} element={
                <Greeting username={username}></Greeting>
            }/>
            <Route path="*" element={<h1>404!</h1>}/>
            <Route path="giraffes" element={<GiraffePage/>}/>
            <Route path="praktik" element={<WorkdaysPage/>}/>

            <Route path={"experiments"} element={<ExperimentPage/>}/>
        </Routes>

    );
}

export default observer(App);
