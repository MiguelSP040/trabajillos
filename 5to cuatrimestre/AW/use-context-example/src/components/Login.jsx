import React, { useContext } from "react";
import {AppContext} from "../App.jsx";

export default function Login(props) {

const {setUsername} = useContext(AppContext)

    const updateInput = (event) => {
        props.setUsername(event.target.value)
    }
    return(
        <div>
            <input type="text" onChange={(event) => props.setUsername(event.target.value)}>
            
            </input>
        </div>
    )
}
