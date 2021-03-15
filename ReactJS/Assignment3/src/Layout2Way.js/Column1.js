import React from 'react'
class Column1 extends React.Component {
render(){
    return(
        <div className={this.props.className} style={{background: "grey"}}>Column 1</div>
    )
}

}
export default Column1;