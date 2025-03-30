import React from "react";

export default function UserComponent(props) {
    return(
        <div>
            <h1>Name: {props.name} </h1>
            <p>Email: {props.email} </p>
            <small>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore corporis quis doloribus quisquam nesciunt labore recusandae, a, soluta incidunt aliquam omnis cupiditate placeat temporibus laudantium quidem necessitatibus consectetur voluptatem! Excepturi.</small>
            {props.children}
        </div>
    )
}