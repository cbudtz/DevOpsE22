import {useParams} from "react-router-dom";

export const Greeting = ({username}) => {
    let {value} = useParams();
    return (<h1>Hello, {username} - pressed: {value}</h1>)
}