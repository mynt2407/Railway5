import React from "react";
import { useParams } from "react-router-dom";

function PersonDetail() {
    // const id = props.match.params.id;
    // const firstName = props.match.params.firstName;

    let { id } = useParams();
    console.log(id);
    
    let { firstName1 } = useParams();
   
    return (
        <div>
            <h3 style={{ color: 'green' }}>PersonID : {id}</h3>
            <h3 style={{ color: 'green' }}>FirstName : {firstName1}</h3>
        </div>
    )
}
export default PersonDetail;