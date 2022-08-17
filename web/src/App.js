import './App.css';
import {useState} from "react";

function App() {
    const [username, setUsername] = useState("Brian")
    return (
        <div className="App">
            <div>Hello, {username}</div>
            <button onClick={(e)=>setUsername("Johnny")}>Skift navn</button>
        </div>
    );
}
const Greeting = ({username})=> {
    return (<h1>Hello, {username}</h1>)
}

export default App;
