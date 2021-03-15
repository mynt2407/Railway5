import React from "react";
import MenuItem from "./MenuItem";

function Menu(props) {
    const ListRender = props.menuList.map((item, index) => {
        return (
            <MenuItem
                key={index}
                name={item.name}
                icon={item.icon}
                path={item.path}
            />
        )
    })
    return(
        <div style={{width : props.width}}>
            {ListRender}
        </div>
    )

}
export default Menu;