import React, { useContext } from "react";
import {AppContext} from "../App";

export default function User(props) {
    const {username} = useContext(AppContext)
    return(
        <div>
            <h1>{props.username}</h1>
        </div>
    )
}