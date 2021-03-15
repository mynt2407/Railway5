import React from "react";
import MenuItem from "./MenuItem";

function Menu(props) {

    const listRender = props.menuList.map((item, index) => {
        return (
            <MenuItem
                key={index}
                icon={item.icon}
                name={item.name}
                path={item.path}
            />);
    });

    return (
        <div style={{ width: props.width }}>
            {listRender}
        </div>
    );
}

export default Menu;