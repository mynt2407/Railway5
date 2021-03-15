function Inputname(props) {

    const handleChange = (event) => {
        //send data den parent
        
    }
    return (
        <div>
            <label>
                Name: <input type = 'text' value= {props.name}> onChange ={this.handleChange} </input>
            </label>
        </div>
    )

}