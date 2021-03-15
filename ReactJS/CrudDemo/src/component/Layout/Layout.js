import React from 'react';

function Layout(props) {
return(
    <div>
        <div>
            {props.top}
        </div>

         <div>
            {props.center}
        </div>
        
        <div>
            {props.bottom}
        </div>
    </div>
)

}
export default Layout;